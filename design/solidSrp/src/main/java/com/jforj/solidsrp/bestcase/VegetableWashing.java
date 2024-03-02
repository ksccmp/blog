package com.jforj.solidsrp.bestcase;

public class VegetableWashing {

    public void wash(long count) {
        System.out.println("채소를 씻습니다.");
        System.out.println("씻어야 되는 채소의 총 갯수는 " + count + "개 입니다.");

        if (count > 10) {
            System.out.println("채소를 씻을 때 바구니를 사용해야 합니다.");
        }
    }
}
