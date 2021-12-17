package ru.dimedrollo.Hometask10;

import java.awt.*;

public class Square extends Rectangle implements Motion{

    private int side;

    public Square(int x) {
        super(x, x);
        this.side = x * 2;
    }

    @Override
    public double getPerimeter() {
        return 2 * (side * 2);
    }

    @Override
    public void move(Point p) {
        setCenter(p);
    }
}