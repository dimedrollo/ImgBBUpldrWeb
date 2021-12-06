package ru.dimedrollo.Hometask09;


public class Circle extends Ellipse {

    private int diametr;

    public Circle(int x) {
        super(x, x);
        this.diametr = x;
    }


    @Override
    public double getPerimeter() {
        return diametr * 3.14;
    }


}
