package ru.dimedrollo.Hometask20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/home/dopegeek/IdeaProjects/innopolis-homework/cars"));
           System.out.println(Stream.of(reader.readLine().split("|")).toArray());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}