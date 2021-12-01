package ru.dimedrollo.Hometask10;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        Figure[] figures  = new Figure[4];
        figures[0] = new Ellipse(7,5);
        figures[1] = new Circle(44);
        figures[2] = new Ellipse(11,2);
        figures[3] = new Circle(-4);
        int[]a ={1,-1};
        for (Figure f : figures) {
            f.move(a);
            System.out.println("x = "+ f.getX() + "; y = " +f.getY());
        }
    }
}

