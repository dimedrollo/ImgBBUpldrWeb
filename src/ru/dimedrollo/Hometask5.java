package ru.dimedrollo;

import java.util.Scanner;

class Hometask5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if (a == -1) {
            System.out.println("Program exit");
        } else {
            int minDigit = 10;
            a = Math.abs(a);
            while (a != -1) {
                while (a != 0) {
                    int b = a % 10;
                    a = a / 10;
                    if (b < minDigit) {
                        minDigit = b;
                    }
                }
                a = scanner.nextInt();
            }
            System.out.println(minDigit);
        }
    }
}

