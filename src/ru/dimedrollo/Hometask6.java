package ru.dimedrollo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hometask6 {


    /**
     * The function return the index of this number in the array
     *
     * @param a   the desired number
     * @param arr array of numbers
     * @return index of desired number into array arr
     */
    public static int getIndex(int a, Integer[] arr) {
        List<Integer> list = Arrays.asList(arr);
        return list.indexOf(a);
    }


    /**
     * A procedure that moves all significant elements of an array to the left by filling in the null ones
     *
     * @param arr array of integers
     */
    public static void replaceZero(Integer[] arr) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int counter = 0;
        for (Integer i : arr) {
            if (i == 0) {
                counter++;
            } else arrayList.add(i);
        }

        for (int i = 0; i < counter; i++) {
            arrayList.add(0);
        }
        System.out.println(arrayList);
    }


    public static void main(String[] args) {
        Integer[] arr = {34, 0, 0, 14, 15, 0, 18, 0, 0, 1, 20};
        replaceZero(arr);
        System.out.println(getIndex(7, arr));
    }
}
