package ru.dimedrollo.Hometask13;

import java.util.ArrayList;
import java.util.List;

public class Sequence {


    public static Object[] filter(Integer[] array, ByCondition condition) {
        List<Integer> list = new ArrayList<>();
        for (Integer a : array) {
            if (condition.isOk(a)) {
                list.add(a);
            }
        }

        return list.toArray();
    }

    static Integer getDigitSum(Integer number) {
        Integer a = 0;
        while (number / 10 != 0) {
            a = a + number % 10;
            number = number / 10;
        }
        return a;
    }

}
