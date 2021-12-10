package ru.dimedrollo.Hometask13;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Integer[] arr = {9, 11, 333, 555, 146, 84, 10};

        Object[] filtered = Sequence.filter(arr, number -> number % 2 == 0 && Sequence.getDigitSum(number) % 2 == 0);


        System.out.println(Arrays.toString(filtered));

    }
}

