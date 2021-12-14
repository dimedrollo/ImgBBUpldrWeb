package ru.dimedrollo.Hometask10;


import java.awt.*;

public class Circle extends Ellipse implements Motion {

    private int diametr;

    public Circle(int x) {
        super(x, x);
        this.diametr = x;
    }


    @Override
    public double getPerimeter() {
        return diametr * 3.14;
    }


    @Override
    public void move(Point p) {
        setCenter(p);
    }
}
