package com.jforj.solidlsp.badcase;

public class Warrior {

    private int power;

    public void setPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public int getDamage() {
        return getPower() * 1;
    }
}
