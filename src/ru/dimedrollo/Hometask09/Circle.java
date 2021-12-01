package ru.dimedrollo.Hometask09;


public class Circle extends Ellipse {

    public Circle(double x) {
        super(x, x);
    }


    @Override
    public double getPerimeter() {
        return x * 3.14;
    }


}
