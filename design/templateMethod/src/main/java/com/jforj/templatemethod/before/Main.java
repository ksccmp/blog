package com.jforj.templatemethod.before;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Shape();
        circle.printShape("circle", 0, 0, 3);

        Shape rectangle = new Shape();
        rectangle.printShape("rectangle", 4, 3, 0);
    }
}
