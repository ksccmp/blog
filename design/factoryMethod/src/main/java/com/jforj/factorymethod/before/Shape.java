package com.jforj.factorymethod.before;

public class Shape {

    private String type;
    private String color;

    public Shape(String type) {
        this.type = type;
        init();
    }

    private void init() {
        // 공통 초기화
        System.out.println("start init.");

        // type별 초기화
        switch (type) {
            case "circle": {
                this.color = "red";
                break;
            }

            case "rectangle": {
                this.color = "blue";
                break;
            }

            case "square": {
                this.color = "green";
                break;
            }
        }
    }

    public void printShape() {
        // type별 출력
        switch (type) {
            case "circle": {
                System.out.println("this is circle.");
                break;
            }

            case "rectangle": {
                System.out.println("this is rectangle.");
                break;
            }

            case "square": {
                System.out.println("this is square.");
                break;
            }
        }

        // 공통 출력
        System.out.println("color is " + this.color);
    }
}
