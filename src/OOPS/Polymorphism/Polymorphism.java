package OOPS.Polymorphism;

class Shape {
    void draw() {
        System.out.println("Drawing Shape");
    }
}
class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Circle");
    }
}
class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Rectangle");
    }
}
public class Polymorphism {
    public static void main(String[] args) {
        Shape[] shapes = {new Circle(), new Rectangle()};
        for (Shape s : shapes) {
            s.draw();
        }
    }
}