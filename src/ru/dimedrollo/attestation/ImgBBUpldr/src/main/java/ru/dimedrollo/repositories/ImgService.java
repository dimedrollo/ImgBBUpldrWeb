package ru.dimedrollo.repositories;

import org.springframework.web.bind.annotation.ResponseBody;
import ru.dimedrollo.models.Img;
import ru.dimedrollo.models.UploadParameters;

import java.util.List;

public interface ImgService {

    List<Img>  findAll();
    void save(Img img);
    void responseBody(UploadParameters params, Img image);

}
