package com.jforj.solidlsp.badcase;

public class NewWarrior extends Warrior {

    @Override
    public int getDamage() {
        return getPower() * 2;
    }
}
