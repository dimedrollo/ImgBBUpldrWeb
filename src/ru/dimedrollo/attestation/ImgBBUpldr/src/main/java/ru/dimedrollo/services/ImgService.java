package ru.dimedrollo.services;

import ru.dimedrollo.models.Img;
import ru.dimedrollo.models.UploadParameters;

public interface ImgService {


    void responseBody(UploadParameters params, Img image);

}
