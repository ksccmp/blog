package com.jforj.solidisp.badcase;

public class BluetoothEarPhone implements EarPhone {

    @Override
    public void connection() {
        System.out.println("블루투스를 이용하여 연결");
    }

    @Override
    public void listenSound() {
        System.out.println("이어폰 몸체를 귀에 고정");
    }

    @Override
    public void charge() {
        System.out.println("충전 케이스에 연결");
    }

    @Override
    public void turnUpSound() {
        System.out.println("오른쪽 이어폰 몸체 터치");
    }

    @Override
    public void turnDownSound() {
        System.out.println("왼쪽 이어폰 몸체 터치");
    }
}
