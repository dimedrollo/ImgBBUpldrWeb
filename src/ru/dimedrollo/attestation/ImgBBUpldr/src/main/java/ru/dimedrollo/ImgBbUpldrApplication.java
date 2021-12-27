package ru.dimedrollo;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImgBbUpldrApplication {

    @SneakyThrows
    public static void main(String[] args) {
        SpringApplication.run(ImgBbUpldrApplication.class, args);
    }
}
