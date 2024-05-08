package com.jforj.abstractfactory.beforefactorymethod.button;

public class ChromeButton implements BrowserButton {

    @Override
    public void print() {
        System.out.println("chrome button create");
    }
}
