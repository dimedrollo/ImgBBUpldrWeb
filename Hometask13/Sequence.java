package ru.dimedrollo.Hometask13;

import java.util.ArrayList;
import java.util.List;

public class Sequence {


    public static int[] filter(int[] array, ByCondition condition) {
        List<Integer> list = new ArrayList<>();
        for (int a : array) {
            if (condition.isOk(a)) {
                list.add(a);
            }
        }
        int[] filtered = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            filtered[i] = list.get(i);
        }

        return filtered;
    }

    static int getDigitSum(int number) {
        int a = 0;
        while (number / 10 != 0) {
            a = a + number % 10;
            number = number / 10;
        }
        return a;
    }

}
