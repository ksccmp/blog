package com.jforj.solidisp.badcase;

public class Main {
    public static void main(String[] args) {
        // 유선 이어폰
        WiredEarPhone wiredEarPhone = new WiredEarPhone();
        wiredEarPhone.connection();
        wiredEarPhone.listenSound();
        // wiredEarPhone.charge();
        // wiredEarPhone.turnUpSound();
        // wiredEarPhone.turnDownSound();

        // 블루투스 이어폰
        BluetoothEarPhone bluetoothEarPhone = new BluetoothEarPhone();
        bluetoothEarPhone.connection();
        bluetoothEarPhone.listenSound();
        bluetoothEarPhone.charge();
        bluetoothEarPhone.turnUpSound();
        bluetoothEarPhone.turnDownSound();
    }
}
