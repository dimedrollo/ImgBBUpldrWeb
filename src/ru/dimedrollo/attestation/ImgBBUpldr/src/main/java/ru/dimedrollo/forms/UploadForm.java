package ru.dimedrollo.forms;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Data
@Component
public class UploadForm {

    private MultipartFile file;
    private Long timer;
    private String unit;

    public Long convertTimeByUnits() {
        if (timer == null || timer == 0){
            setTimer(1l);
        }
        switch (unit) {
            case "HOUR":
                setTimer(timer * 60);
                break;
            case "DAY":
                setTimer(timer * 60 * 24);
                break;
            case "WEEK":
                setTimer(timer * 60 * 24 * 7);
                break;
            case "MONTH":
                setTimer(timer * 60 * 24 * 30);
                break;
        }
        return timer;
    }

}
