package com.jforj.templatemethod.after;

public abstract class Shape {
    public void printShape() {
        System.out.println("print common shape.");

        System.out.println("calculate area");
        int area = calculate();

        System.out.println("area of shape is " + area);
    }

    public abstract int calculate();
}
