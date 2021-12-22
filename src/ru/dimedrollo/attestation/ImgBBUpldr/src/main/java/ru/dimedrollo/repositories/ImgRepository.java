package ru.dimedrollo.repositories;

import ru.dimedrollo.models.Img;

import java.util.List;

public interface ImgRepository {


    List<Img> findAll();

    void save(Img img);
}
