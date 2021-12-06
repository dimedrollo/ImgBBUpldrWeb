package ru.dimedrollo.Hometask09;

public class Square extends Rectangle {

    private int side;

    public Square(int x) {
        super(x, x);
        this.side = x * 2;
    }

    @Override
    public double getPerimeter() {
        return 2 * (side * 2);
    }
}