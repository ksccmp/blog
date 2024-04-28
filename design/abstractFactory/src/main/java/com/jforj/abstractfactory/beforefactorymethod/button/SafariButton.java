package com.jforj.abstractfactory.beforefactorymethod.button;

public class EdgeButton implements BrowserButton {

    @Override
    public void print() {
        System.out.println("edge button create");
    }
}
