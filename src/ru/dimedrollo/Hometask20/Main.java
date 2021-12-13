package ru.dimedrollo.Hometask20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/home/dopegeek/IdeaProjects/innopolis-homework/cars"));

            Predicate<List<String>> matter = strings -> strings.contains("Black") || strings.contains("0");
            Function<String, List<String>> lineToStringArray = s1 -> Arrays.asList(s1.split("\\|"));

            Stream<List<String>> stringCars = reader.lines().map(lineToStringArray).filter(matter);
            System.out.println(stringCars.collect(Collectors.toList()));
            reader.close();
        } catch (IOException e) {
            System.out.println("Oops, something went wrong!");
        }
    }
}