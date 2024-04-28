package com.jforj.abstractfactory.after;

public class ChromeButton implements BrowserButton {

    @Override
    public void print() {
        System.out.println("chrome button create");
    }
}
