package com.jforj.abstractfactory.after.button;

public class SafariButton implements BrowserButton {

    @Override
    public void print() {
        System.out.println("safari button create");
    }
}
