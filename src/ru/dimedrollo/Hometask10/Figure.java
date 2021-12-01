package ru.dimedrollo.Hometask10;

abstract public class Figure implements Motion{
    protected double x;
    protected double y;

    public Figure(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public void move(int[] moveTo){};

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getPerimeter() {
        return 0;
    }
}
