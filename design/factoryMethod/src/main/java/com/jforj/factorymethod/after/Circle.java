package com.jforj.factorymethod.after;

public class Circle extends Shape {

    public Circle() {
        // type별 초기화
        this.type = "circle";
        this.color = "red";
    }

    @Override
    public void printShape() {
        // type별 출력
        System.out.println("this is circle.");

        // 공통 출력
        print();
    }
}
