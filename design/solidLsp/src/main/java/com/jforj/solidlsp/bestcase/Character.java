package com.jforj.solidlsp.bestcase;

public class Character {

    private int power;
    private int count;

    public void setPower(int power) {
        this.power = power;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPower() {
        return power;
    }

    public int getCount() {
        return count;
    }

    public int getDamage() {
        return getPower() * getCount();
    }
}