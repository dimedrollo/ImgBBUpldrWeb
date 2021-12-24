package ru.dimedrollo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
    public String addImg(@RequestParam("file") MultipartFile file, @RequestParam(value = "timer", defaultValue = "24") Long timer) throws IOException {
        imgService.makeRequest(file, timer);
        return "redirect:/images";
    }


    @GetMapping("/images")
    public String getImagesPage(Model model) {
        List<Img> images = imgService.getImgRepository().findAll();
        model.addAttribute("images", images);
        return "images";
    }


}
