package com.jforj.solidocp.bestcase;

public class Main {
    public static void main(String[] args) {
        User user = new User();

        // 전사
        Warrior warrior = new Warrior();
        user.attack(warrior);

        // 마법사
        Wizard wizard = new Wizard();
        user.attack(wizard);

        // 도적
        Thief thief = new Thief();
        user.attack(thief);

        // 궁수
        Archer archer = new Archer();
        user.attack(archer);
    }
}
