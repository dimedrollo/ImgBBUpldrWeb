package ru.dimedrollo.Hometask10;


import java.awt.*;

public abstract class Figure {

    protected Point center;

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    protected int width;
    protected int height;

    public Figure(int x, int y) {
        this.center = new Point(x, y);
    }


    public abstract double getPerimeter();
    }

