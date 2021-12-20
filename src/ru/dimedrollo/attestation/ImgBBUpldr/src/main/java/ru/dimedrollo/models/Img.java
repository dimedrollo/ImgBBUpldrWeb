package ru.dimedrollo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Img {
    private String id;
    private String base64;
    private String mUrl;
    private String mTimer; // сюда сохраняем время удаления


    public Img(String base64) {
        this.base64 = base64;
    }



  }