package com.jforj.factorymethod.after;

public class Square extends Shape {

    public Square() {
        // type별 초기화
        this.type = "square";
        this.color = "green";
    }

    @Override
    public void printShape() {
        // type별 출력
        System.out.println("this is square.");

        // 공통 출력
        print();
    }
}
