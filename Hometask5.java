package ru.dimedrollo;

import java.util.Scanner;

class Hometask5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int minDigit = 10;

        while (a != -1) {
            while (a != 0) {
                int b = a % 10;
                a = a / 10;
                if (b < minDigit) minDigit = b;
            }
            a = scanner.nextInt();
        }
        System.out.println(minDigit);
    }
}

