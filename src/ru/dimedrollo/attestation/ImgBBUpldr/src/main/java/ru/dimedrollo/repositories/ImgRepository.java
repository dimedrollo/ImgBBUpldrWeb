package ru.dimedrollo.repositories;

import ru.dimedrollo.models.Img;

import java.util.List;

public interface ImgRepository {

    String SQL_INSERT = "insert into imgbbDB(UUID, IMG_64, URL, TIMER) values (?,?,?,?)";
    String SQL_DELETE = "DELETE FROM imgbbDB";
    String SQL_SELECT = "SELECT * FROM imgbbDB";

    List<Img> findAll();

    void save(Img img);
}
