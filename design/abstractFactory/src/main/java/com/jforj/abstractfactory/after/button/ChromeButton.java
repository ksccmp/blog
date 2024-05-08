package com.jforj.abstractfactory.after.button;

public class ChromeButton implements BrowserButton {

    @Override
    public void print() {
        System.out.println("chrome button create");
    }
}
