package ru.dimedrollo.repositories;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import ru.dimedrollo.models.Img;
import ru.dimedrollo.models.UploadParameters;
import ru.dimedrollo.models.response.OptionalResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class ImgServiceJdbcTemplate implements ImgService {

    private static final String API_URL = "https://api.imgbb.com/1/upload";
    private static final String USER_AGENT = "imgbbUpldr";
    private static final int TIMEOUT = 50000;
    private static final String SQL_INSERT = "insert into imgbbDB(UUID, IMG_64, URL, TIMER) values (?,?,?,?)";
    private static String SQL_DELETE = "SELECT FROM imgbbDB WHERE (TIMER) > ";
    private static final String SQL_SELECT = "SELECT * FROM imgbbDB";
    private JdbcTemplate jdbcTemplate;

    public static String makeFormattedDate(Date date) {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        return formatDate.format(date);
    }

    public static LocalDateTime makeFormattedDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);

        return dateTime;
    }

    private static final RowMapper<Img> imgRowMapper = (row, rowNumber) -> {
        String uuid = row.getString("UUID");
        String base64 = row.getString("IMG_64");
        String timer = row.getString("TIMER");
        String url = row.getString("URL");

        return new Img(uuid, base64, url, timer);

    };

    @Autowired
    public ImgServiceJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Img> findAll() {
        List<Img> list = jdbcTemplate.query(SQL_SELECT, imgRowMapper);
        List<Img> newList = new ArrayList<>();
        for (Img img : list) {
            if (makeFormattedDate(img.getMTimer()).isAfter(LocalDateTime.now())) {
                newList.add(img);
            }
        }
        return newList;
    }

    // TODO: DB rewriting without old data

    public void responseBody(@RequestParam UploadParameters uploadParam, Img image) {
        try {
            Connection.Response response = Jsoup.connect(API_URL)
                    .ignoreContentType(true)
                    .ignoreHttpErrors(true)
                    .method(Connection.Method.POST)
                    .data(uploadParam.toMap())
                    .timeout(TIMEOUT)
                    .userAgent(USER_AGENT)
                    .execute();
            image.setMUrl(OptionalResponse.of(response).get().getResponseData().getViewerUrl());
            image.setBase64(OptionalResponse.of(response).get().getResponseData().getThumbnail().getUrl());
            save(image);
        } catch (IOException ex) {
            throw new RuntimeException("I/O exception was catched while try to upload image!", ex);
        }
    }

    @Override
    public void save(Img img) {
        jdbcTemplate.update(SQL_INSERT, null, img.getBase64(), img.getMUrl(), img.getMTimer());
    }
}