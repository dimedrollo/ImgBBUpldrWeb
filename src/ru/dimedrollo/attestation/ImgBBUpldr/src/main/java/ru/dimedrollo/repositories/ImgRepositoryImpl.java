package ru.dimedrollo.repositories;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.dimedrollo.models.Img;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class ImgRepositoryImpl implements ImgRepository {

    private static final String SQL_INSERT = "insert into imgbbDB(UUID, IMG_64, URL, TIMER) values (?,?,?,?)";
    private static String SQL_DELETE = "DELETE FROM imgbbDB";
    private static final String SQL_SELECT = "SELECT * FROM imgbbDB";

    private final JdbcTemplate jdbcTemplate;

    /**
     * Put uploaded image to DB
     *
     * @param img
     */
    @Override
    public void save(Img img) {
        jdbcTemplate.update(SQL_INSERT, null, img.getThumbnail(), img.getUrl(), img.getTimer());
    }

    /**
     * Get List<Img> from DB, filter old objects, rewrite DB
     *
     * @return List<Img> on storage server
     */
    @Override
    public List<Img> findAll() {
        List<Img> list = jdbcTemplate.query(SQL_SELECT, imgRowMapper);
        jdbcTemplate.update(SQL_DELETE);
        List<Img> newList = new ArrayList<>();
        for (Img img : list) {
            if (img.makeDateTime().isAfter(LocalDateTime.now())) {
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

}
