package com.jforj.solidisp.bestcase;

public class Main {
    public static void main(String[] args) {
        // 유선 이어폰
        WiredEarPhone wiredEarPhone = new WiredEarPhone();
        wiredEarPhone.connection();
        wiredEarPhone.listenSound();

        // 블루투스 이어폰
        BluetoothEarPhone bluetoothEarPhone = new BluetoothEarPhone();
        bluetoothEarPhone.connection();
        bluetoothEarPhone.listenSound();
        bluetoothEarPhone.charge();
        bluetoothEarPhone.turnUpSound();
        bluetoothEarPhone.turnDownSound();
    }
}
