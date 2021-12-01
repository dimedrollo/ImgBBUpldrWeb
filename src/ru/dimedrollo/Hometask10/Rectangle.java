package ru.dimedrollo.Hometask10;

public  class Rectangle extends Figure {

    public Rectangle(double x, double y) {
        super(x, y);
    }

    @Override
    public double getPerimeter() {
        return Math.sqrt(x * x + y * y) + x + y;
    }
}
