package com.jforj.templatemethod.before;

public class Shape {

    public void printShape(String type, int width, int height, int radius) {
        System.out.println("print common shape.");

        System.out.println("calculate area");
        int area = 0;
        switch (type) {
            case "circle": {
                area = radius * radius;
                break;
            }

            case "rectangle": {
                area = width * height;
                break;
            }
        }

        System.out.println("area of shape is " + area);
    }
}
