package ru.dimedrollo.Hometask10;

import java.awt.*;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

        ArrayList<Motion> list = new ArrayList<>();

        list.add(new Circle(6));
        list.add(new Square(6));

        for (Motion m : list) {
            System.out.println("Координаты центра до перемещения" + m.getClass().getSimpleName() + " = " + m.getCenter().x + ", " + m.getCenter().y);
            m.move(new Point(7, 10));
            System.out.println("Координаты центра после перемещения" + m.getClass().getSimpleName() + " = " + m.getCenter().x + ", " + m.getCenter().y);
        }
    }
}


