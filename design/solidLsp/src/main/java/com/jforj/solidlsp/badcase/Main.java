package com.jforj.solidlsp.badcase;

public class Main {

    public static void main(String[] args) {
        Warrior warrior = new Warrior();
        warrior.setPower(16);
        System.out.println("warrior damage : " + warrior.getDamage());

        Warrior newWarrior = new NewWarrior();
        newWarrior.setPower(16);
        System.out.println("newWarrior damage : " + newWarrior.getDamage());
    }
}
