package ru.dimedrollo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.dimedrollo.forms.UploadForm;
import ru.dimedrollo.models.Img;
import ru.dimedrollo.services.ImgServiceImpl;

import java.io.IOException;
import java.util.List;


@Controller
public class ImgController {

    private final ImgServiceImpl imgService;


    @Autowired
    public ImgController(ImgServiceImpl imgService) {
        this.imgService = imgService;
    }


    @PostMapping("/addimg")
    public String addImg(UploadForm form) throws IOException {

        imgService.makeRequest(form.getFile(), form.convertTimeByUnits());
        return "redirect:/images";
    }


    @GetMapping("/images")
    public String getImagesPage(Model model) {
        List<Img> images = imgService.getImgRepository().findAll();
        model.addAttribute("images", images);
        return "images";
    }


}
