package com.jforj.solidocp.badcase;

public class Main {
    public static void main(String[] args) {
        User user = new User();

        // 전사
        String warrior = "warrior";
        user.attack(warrior);

        // 마법사
        String wizard = "wizard";
        user.attack(wizard);

        // 도적
        String thief = "thief";
        user.attack(thief);

        // 궁수
        String archer = "archer";
        user.attack(archer);
    }
}
