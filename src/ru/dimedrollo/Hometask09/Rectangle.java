package ru.dimedrollo.Hometask09;

public class Rectangle extends Figure {

    public Rectangle(double x, double y) {
        super(x, y);
    }

    @Override
    public double getPerimeter() {
        return 2 * (x + y);
    }
}

