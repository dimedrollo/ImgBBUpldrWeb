package ru.dimedrollo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Img {
    private String id;
    private String thumbnail;
    private String url;
    private String timer;

    /**
     * Convert date to nice view and put into this.timer
     *
     * @param date
     * @return
     */
    public void makeFormattedDate(Date date) {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        timer = formatDate.format(date);
    }

    /**
     * Convert this.timer in nice view to LocalDateTime
     *
     * @param
     * @return
     */
    public LocalDateTime makeDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(timer, formatter);
        return dateTime;
    }
}