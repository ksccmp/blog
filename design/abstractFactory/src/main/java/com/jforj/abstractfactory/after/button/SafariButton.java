package com.jforj.abstractfactory.after.button;

public class EdgeButton implements BrowserButton {

    @Override
    public void print() {
        System.out.println("edge button create");
    }
}
