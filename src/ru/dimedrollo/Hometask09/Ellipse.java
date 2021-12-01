package ru.dimedrollo.Hometask09;


public class Ellipse extends Figure {
    public Ellipse(double x, double y) {
        super(x, y);
    }

    @Override
    public double getPerimeter() {
        double a = x / 2;
        double b = y / 2;
        double pi = 3.14;
        return pi * (3 * (a + b) - Math.sqrt((3 * a + b) * (a + 3 * b)));
    }
}
