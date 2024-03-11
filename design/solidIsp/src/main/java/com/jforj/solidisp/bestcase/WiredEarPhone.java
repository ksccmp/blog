package com.jforj.solidisp.bestcase;

public class WiredEarPhone implements EarPhone {

    @Override
    public void connection() {
        System.out.println("선을 이용하여 연결");
    }

    @Override
    public void listenSound() {
        System.out.println("이어폰 몸체를 귀에 고정");
    }
}
