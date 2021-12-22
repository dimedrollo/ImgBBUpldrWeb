package ru.dimedrollo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Img {
    private String id;
    private String thumbnail;
    private String mUrl;
    private String mTimer; // сюда сохраняем время удаления


    public Img(String thumbnail) {
        this.thumbnail = thumbnail;
    }



  }