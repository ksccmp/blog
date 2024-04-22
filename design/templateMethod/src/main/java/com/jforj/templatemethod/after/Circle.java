package com.jforj.templatemethod.after;

public class Circle extends Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public int calculate() {
        return radius * radius;
    }
}
