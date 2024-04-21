package com.jforj.factorymethod.after;

public class Main {
    public static void main(String[] args) {
        Shape circle = new CircleFactory().getInstance();
        Shape rectangle = new RectangleFactory().getInstance();
        Shape square = new SquareFactory().getInstance();

        circle.printShape();
        rectangle.printShape();
        square.printShape();
    }
}
