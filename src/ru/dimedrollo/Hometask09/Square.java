package ru.dimedrollo.Hometask09;

public class Square extends Rectangle {

    public Square(double x) {
        super(x, x);
    }

    @Override
    public double getPerimeter() {
        return 2 * (x + x);
    }
}