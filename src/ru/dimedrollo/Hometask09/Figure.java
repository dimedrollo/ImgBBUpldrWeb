package ru.dimedrollo.Hometask09;


import java.awt.*;

public class Figure {

    protected Point center;
    protected int width;
    protected int height;

    public Figure(int x, int y) {
        this.center = new Point(x, y);
    }


    public double getPerimeter() {
        return 0;
    }
}
