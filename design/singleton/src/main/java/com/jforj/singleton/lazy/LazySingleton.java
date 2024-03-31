package com.jforj.singleton.lazy;

public class LazySingleton {
    private static LazySingleton instance; // 클래스의 유일한 인스턴스 객체

    /**
     * 클래수 내부에서만 생성자를 호출할 수 있도록 private 설정
     */
    private LazySingleton() {
        System.out.println("[constructor] ======> call singleton constructor");
    }

    /**
     * 유일한 인스턴스 객체 반환
     */
    public static LazySingleton getInstance() {
        // 생성된 인스턴스 객체가 없는 경우에만 새롭게 생성
        if(instance == null) {
            instance = new LazySingleton();
        }

        return instance;
    }

    public void print() {
        System.out.println("[print] ======> singleton object");
    }
}
