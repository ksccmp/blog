package com.jforj.factorymethod.after;

public abstract class Shape {

    protected String type;
    protected String color;

    void print() {
        // 공통 출력
        System.out.println("color is " + this.color);
    }

    abstract void printShape();
}
