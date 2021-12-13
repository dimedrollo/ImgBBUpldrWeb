package ru.dimedrollo.Hometask09;

public class Rectangle extends Figure {

    private int width;
    private int height;

    public Rectangle(int x, int y) {
        super(x, y);
        this.width = x * 2;
        this.height = y * 2;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}

