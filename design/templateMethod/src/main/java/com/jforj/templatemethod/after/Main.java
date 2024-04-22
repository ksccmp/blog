package com.jforj.templatemethod.after;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(3);
        circle.printShape();

        Shape rectangle = new Rectangle(4, 3);
        rectangle.printShape();
    }
}
