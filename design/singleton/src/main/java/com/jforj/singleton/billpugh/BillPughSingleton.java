package com.jforj.singleton.billpugh;

public class BillPughSingleton {
    private static BillPughSingleton instance; // 클래스의 유일한 인스턴스 객체

    /**
     * 클래수 내부에서만 생성자를 호출할 수 있도록 private 설정
     */
    private BillPughSingleton() {
        System.out.println("[constructor] ======> call singleton constructor");
    }

    /**
     * static class를 활용한 인스턴스 holding
     */
    private static class InstanceHolder {
        private static final BillPughSingleton Instance = new BillPughSingleton();
    }

    /**
     * 유일한 인스턴스 객체 반환
     */
    public static BillPughSingleton getInstance() {
        return InstanceHolder.Instance;
    }

    public void print() {
        System.out.println("[print] ======> singleton object");
    }
}
