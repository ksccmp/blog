package com.jforj.solidsrp.badcase;

public class Main {
    public static void main(String[] args) {
        Washing washing = new Washing();

        // 사람
        String person = "person";
        washing.wash(person, "타올", 0);

        // 채소
        String vegetable = "vegetable";
        washing.wash(vegetable, null, 12);

        // 자동차
        String car = "car";
        washing.wash(car, null, 0);
    }
}
