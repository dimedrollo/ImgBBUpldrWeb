package ru.dimedrollo.services;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import ru.dimedrollo.models.Img;
import ru.dimedrollo.models.UploadParameters;
import ru.dimedrollo.models.response.OptionalResponse;
import ru.dimedrollo.repositories.ImgRepositoryImpl;

import java.io.IOException;

@Component
public class ImgServiceImpl implements ImgService {

    private static final String API_URL = "https://api.imgbb.com/1/upload";
    private static final String USER_AGENT = "imgbbUpldr";
    private static final int TIMEOUT = 50000;

    @Autowired
    public ImgRepositoryImpl getImgRepository() {
        return imgRepository;
    }

    @Autowired
    private ImgRepositoryImpl imgRepository;


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
            image.setUrl(OptionalResponse.of(response).get().getResponseData().getViewerUrl());
            image.setThumbnail(OptionalResponse.of(response).get().getResponseData().getThumbnail().getUrl());
            imgRepository.save(image);
        } catch (IOException ex) {
            throw new RuntimeException("I/O exception was catched while try to upload image!", ex);
        }
    }

}