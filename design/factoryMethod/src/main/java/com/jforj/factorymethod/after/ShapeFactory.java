package com.jforj.factorymethod.after;

public interface ShapeFactory {

    default Shape getInstance() {
        // 공통 초기화
        System.out.println("start init.");
        return createShape();
    }

    Shape createShape();
}
