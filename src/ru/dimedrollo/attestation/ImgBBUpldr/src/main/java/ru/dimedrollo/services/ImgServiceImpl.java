package ru.dimedrollo.services;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.dimedrollo.forms.UploadForm;
import ru.dimedrollo.models.ExpirationTime;
import ru.dimedrollo.models.Img;
import ru.dimedrollo.models.UploadParameters;
import ru.dimedrollo.models.response.OptionalResponse;
import ru.dimedrollo.repositories.ImgRepository;
import ru.dimedrollo.repositories.ImgRepositoryImpl;

import java.io.IOException;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class ImgServiceImpl implements ImgService {

    @Getter
    private final ImgRepositoryImpl imgRepository;


    @Override
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

    /**
     * create UploadParametrs, and  new Img() from UploadForm and send it to responseBody()
     * @param file from UploadForm
     * @param timer from UploadForm.convertTimeByUnits()
     * @throws IOException
     */
    public void makeRequest(MultipartFile file, Long timer) throws IOException {
        String string64 = Base64Utils.encodeToString(file.getBytes());
        Img image = new Img();
        image.makeFormattedDate(new Date(timer * 60000 + System.currentTimeMillis()));
        UploadParameters.Builder builder = new UploadParameters.Builder();
        ExpirationTime eX = ExpirationTime.fromLong(timer);
        UploadParameters uploadParam = builder.imageBase64(string64).expirationTime(eX).build();
        responseBody(uploadParam, image);
    }
}