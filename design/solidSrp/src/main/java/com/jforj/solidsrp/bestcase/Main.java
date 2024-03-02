package com.jforj.solidsrp.bestcase;

public class Main {
    public static void main(String[] args) {
        // 사람
        PersonWashing personWashing = new PersonWashing();
        personWashing.wash("타올");

        // 채소
        VegetableWashing vegetableWashing = new VegetableWashing();
        vegetableWashing.wash(12);

        // 자동차
        CarWashing carWashing = new CarWashing();
        carWashing.wash();
    }
}
