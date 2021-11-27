import java.util.*;


public class Hometask9 {

    public static class Figure {
        protected double x;
        protected double y;

        public Figure(double x, double y) {
            this.x = x;
            this.y = y;
        }

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

    public static class Ellipse extends Figure {
        public Ellipse(double x, double y) {
            super(x, y);
        }

        @Override
        public double getPerimeter() {
            double a = x / 2;
            double b = y / 2;
            double pi = 3.14;
            return pi * (3 * (a + b) - Math.sqrt((3 * a + b) * (a + 3 * b)));
        }
    }


    public static class Rectangle extends Figure {

        public Rectangle(double x, double y) {
            super(x, y);
        }

        @Override
        public double getPerimeter() {
            return Math.sqrt(x * x + y * y) + x + y;
        }
    }

    public static class Circle extends Ellipse {

        public Circle(double x) {
            super(x, x);
        }

        @Override
        public double getPerimeter() {
            return x * 3.14;
        }
    }

    public static class Square extends Rectangle {

        public Square(double x) {
            super(x, x);
        }

        @Override
        public double getPerimeter() {
            return 2 * (x + x);
        }
    }


    public static void main(String[] args) {

        ArrayList<Figure> list = new ArrayList<>();
        list.add(new Figure(6, 7));
        list.add(new Ellipse(6, 7));
        list.add(new Rectangle(6, 7));
        list.add(new Circle(6));
        list.add(new Square(6));

        for (Figure f : list) {
            System.out.println("Периметр фигуры " + f.getClass().getSimpleName() + " = " + f.getPerimeter());
        }
    }
}
