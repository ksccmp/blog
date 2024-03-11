package com.jforj.solidisp.badcase;

public class WiredEarPhone implements EarPhone {

    @Override
    public void connection() {
        System.out.println("선을 이용하여 연결");
    }

    @Override
    public void listenSound() {
        System.out.println("이어폰 몸체를 귀에 고정");
    }

    @Override
    public void charge() {
        throw new RuntimeException("충전 기능을 제공하지 않습니다.");
    }

    @Override
    public void turnUpSound() {
        throw new RuntimeException("볼륨 높이는 기능을 제공하지 않습니다.");
    }

    @Override
    public void turnDownSound() {
        throw new RuntimeException("볼륨 낮추는 기능을 제공하지 않습니다.");
    }
}
