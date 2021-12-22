package ru.dimedrollo.repositories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.dimedrollo.models.Img;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ImgRepositoryImpl implements ImgRepository {
    private static final String SQL_INSERT = "insert into imgbbDB(UUID, IMG_64, URL, TIMER) values (?,?,?,?)";
    private static String SQL_DELETE = "DELETE FROM imgbbDB";
    private static final String SQL_SELECT = "SELECT * FROM imgbbDB";
    private static JdbcTemplate jdbcTemplate;


    @Autowired


    public ImgRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Put uploaded image to DB
     * @param img
     */
    @Override
    public void save(Img img) {
        jdbcTemplate.update(SQL_INSERT, null, img.getThumbnail(), img.getMUrl(), img.getMTimer());
    }

    /**
     * Get List<Img> from DB, filter old objects, rewrite DB
     * @return List<Img> on storage server
     */
    @Override
    public List<Img> findAll() {
        List<Img> list = jdbcTemplate.query(SQL_SELECT, imgRowMapper);
        jdbcTemplate.update(SQL_DELETE);
        List<Img> newList = new ArrayList<>();
        for (Img img : list) {
            if (makeFormattedDate(img.getMTimer()).isAfter(LocalDateTime.now())) {
                newList.add(img);
                save(img);
            }
        }
        return newList;
    }

    private static final RowMapper<Img> imgRowMapper = (row, rowNumber) -> {
        String uuid = row.getString("UUID");
        String base64 = row.getString("IMG_64");
        String timer = row.getString("TIMER");
        String url = row.getString("URL");
        return new Img(uuid, base64, url, timer);
    };

    /**
     * Convert date to nice view
     * @param date
     * @return
     */
    public static String makeFormattedDate(Date date) {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        return formatDate.format(date);
    }

    /**
     * Convert date in nice view to LocalDateTime
     * @param date
     * @return
     */
    private static LocalDateTime makeFormattedDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        return dateTime;
    }

}
