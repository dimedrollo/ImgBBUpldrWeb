package ru.dimedrollo.Hometask16;


public class Main {
    public static void main(String[] args) {
        int[] arr = {9, 11, 333, 555, 146, 84, 10};
        ArrayList a = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            a.add(arr[i]);
        }
        a = a.removeAt(2);
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }

        LinkedList b = new LinkedList();
        for (int i = 0; i < arr.length; i++) {
            b.add(arr[i]);
        }

        System.out.println("\n" + b.get(2));
    }


}
