package ru.dimedrollo.Hometask13;

public class Main {

    public static void main(String[] args) {
        int[] arr = {9, 11, 333, 555, 146, 84, 10};

        int[] filtered = Sequence.filter(arr, number -> number % 2 == 0 && Sequence.getDigitSum(number) % 2 == 0);

        for (int i = 0; i < filtered.length; i++) {
            System.out.println(filtered[i]);
        }
    }
}

