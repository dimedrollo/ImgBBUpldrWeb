package ru.dimedrollo.controllers;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.dimedrollo.models.ExpirationTime;
import ru.dimedrollo.models.Img;
import ru.dimedrollo.models.UploadParameters;
import ru.dimedrollo.models.response.OptionalResponse;
import ru.dimedrollo.repositories.ImgService;
import ru.dimedrollo.repositories.ImgServiceJdbcTemplate;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class ImgController {



    @Autowired
    private ImgService imgService;

    @Autowired
            public ImgController(ImgService imgService){
        this.imgService = imgService;
    }

Img image;

 @PostMapping("/addimg")
    public String addImg(@RequestParam("file") MultipartFile file, @RequestParam("timer") Long timer) throws IOException {
     String string64 = Base64Utils.encodeToString(file.getBytes());
     image = new Img(string64);
     UploadParameters.Builder builder = new UploadParameters.Builder();
     ExpirationTime eX = ExpirationTime.fromLong(timer);
     UploadParameters uploadParam = builder.imageBase64(string64).expirationTime(eX).build();
     image.setMTimer(ImgServiceJdbcTemplate.makeFormattedDate(new Date(timer*60000+System.currentTimeMillis())));
     imgService.responseBody(uploadParam, image);
     return "redirect:/images";
    }

    
    @GetMapping("/images")
    public String getImagesPage(Model model){
          List<Img> images = imgService.findAll();
     model.addAttribute("images", images);
     return "images";
    }


}
