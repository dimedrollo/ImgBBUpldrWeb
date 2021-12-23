package ru.dimedrollo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.dimedrollo.models.ExpirationTime;
import ru.dimedrollo.models.Img;
import ru.dimedrollo.models.UploadParameters;
import ru.dimedrollo.services.ImgServiceImpl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class ImgController {

    private final ImgServiceImpl imgService;

    @Autowired
    public ImgController(ImgServiceImpl imgService) {
        this.imgService = imgService;
    }

    Img image;

    @PostMapping("/addimg")
    public String addImg(@RequestParam("file") MultipartFile file, @RequestParam(value = "timer", defaultValue = "1440") Long timer) throws IOException {
        String string64 = Base64Utils.encodeToString(file.getBytes());
        image = new Img();
        UploadParameters.Builder builder = new UploadParameters.Builder();
        ExpirationTime eX = ExpirationTime.fromLong(60);
        UploadParameters uploadParam = builder.imageBase64(string64).expirationTime(eX).build();
        image.makeFormattedDate(new Date(timer * 60000 + System.currentTimeMillis()));
        imgService.responseBody(uploadParam, image);
        return "redirect:/images";
    }


    @GetMapping("/images")
    public String getImagesPage(Model model) {
        List<Img> images = imgService.getImgRepository().findAll();
        model.addAttribute("images", images);
        return "images";
    }


}
