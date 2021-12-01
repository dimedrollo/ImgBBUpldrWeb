package ru.dimedrollo.Hometask09;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

        ArrayList<Figure> list = new ArrayList<>();
        list.add(new Figure(6, 7));
        list.add(new Ellipse(6, 7));
        list.add(new Rectangle(6, 7));
        list.add(new Circle(6));
        list.add(new Square(6));

        for (Figure f : list) {
            System.out.println("Периметр фигуры " + f.getClass().getSimpleName() + " = " + f.getPerimeter());
        }
    }
}


