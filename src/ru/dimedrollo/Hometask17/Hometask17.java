package ru.dimedrollo.Hometask17;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hometask17 {

    public static HashMap<String, Integer> countWords(String input) {
        HashMap<String, Integer> wordsMap = new HashMap<>();
        String[] arr = input.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (wordsMap.containsKey(arr[i])) {
                int a = wordsMap.get(arr[i]);
                wordsMap.replace(arr[i], a + 1);
            } else {
                wordsMap.put(arr[i], 1);
            }
        }
        return wordsMap;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> wordsMap = countWords(scanner.nextLine());
        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());

        }
    }
}
