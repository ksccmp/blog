package com.jforj.factorymethod.before;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Shape("circle");
        Shape rectangle = new Shape("rectangle");
        Shape square = new Shape("square");

        circle.printShape();
        rectangle.printShape();
        square.printShape();
    }
}
