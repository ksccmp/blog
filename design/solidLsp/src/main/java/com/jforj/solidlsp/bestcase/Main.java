package com.jforj.solidlsp.bestcase;

public class Main {

    public static void main(String[] args) {
        printWarrior();
        printNewWarrior();
    }

    public static void printWarrior() {
        Character warrior = new Warrior();
        warrior.setPower(16);
        warrior.setCount(1);
        System.out.println("warrior damage : " + warrior.getDamage());

        Character character = new Character();
        character.setPower(16);
        character.setCount(1);
        System.out.println("warrior character damage : " + character.getDamage());
    }

    public static void printNewWarrior() {
        Character newWarrior = new NewWarrior();
        newWarrior.setPower(16);
        newWarrior.setCount(2);
        System.out.println("newWarrior damage : " + newWarrior.getDamage());

        Character character = new Character();
        character.setPower(16);
        character.setCount(2);
        System.out.println("newWarrior character damage : " + character.getDamage());
    }
}