package com.jforj.factorymethod.after;

public class Rectangle extends Shape {

    public Rectangle() {
        // type별 초기화
        this.type = "rectangle";
        this.color = "blue";
    }

    @Override
    public void printShape() {
        // type별 출력
        System.out.println("this is rectangle.");

        // 공통 출력
        print();
    }
}
