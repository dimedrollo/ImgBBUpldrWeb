package ru.dimedrollo.Hometask16;

public class LinkedList<T> extends java.util.LinkedList {

    public T get(int index) {
        LinkedList<T> ll = this;
        Object[] arr = ll.toArray();
        return (T) arr[index];

    }

}
