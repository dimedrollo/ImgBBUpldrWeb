package ru.dimedrollo.Hometask09;


public class Ellipse extends Figure {

    public Ellipse(int x, int y) {
        super(x, y);
        this.width = x * 2;
        this.height = y * 2;
    }

    @Override
    public double getPerimeter() {
        double a = width / 2;
        double b = height / 2;
        double pi = 3.14;
        return pi * (3 * (a + b) - Math.sqrt((3 * a + b) * (a + 3 * b)));
    }
}
