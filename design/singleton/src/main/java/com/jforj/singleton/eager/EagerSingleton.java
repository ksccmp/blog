package com.jforj.singleton.eager;

public class EagerSingleton {
    private static EagerSingleton instance = new EagerSingleton(); // 클래스의 유일한 인스턴스 객체

    /**
     * 클래수 내부에서만 생성자를 호출할 수 있도록 private 설정
     */
    private EagerSingleton() {
        System.out.println("[constructor] ======> call singleton constructor");
    }

    /**
     * 유일한 인스턴스 객체 반환
     */
    public static EagerSingleton getInstance() {
        return instance;
    }

    public void print() {
        System.out.println("[print] ======> singleton object");
    }
}
