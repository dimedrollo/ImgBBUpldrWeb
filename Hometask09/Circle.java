package ru.dimedrollo.Hometask09;

import ru.dimedrollo.Hometask10.Motion;

public class Circle extends Ellipse implements Motion{

    public Circle(double x) {
        super(x, x);
    }


    @Override
    public double getPerimeter() {
        return x * 3.14;
    }

    @Override
    public void move(int[] moveTo) {
        setX(moveTo[0]);
        setY(moveTo[0]);
    }
}
