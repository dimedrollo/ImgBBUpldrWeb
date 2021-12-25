package ru.dimedrollo.services;

import ru.dimedrollo.models.Img;
import ru.dimedrollo.models.UploadParameters;

public interface ImgService {
   String API_URL = "https://api.imgbb.com/1/upload";
   String USER_AGENT = "imgbbUpldr";
   int TIMEOUT = 50000;

   void responseBody(UploadParameters params, Img image);

}
