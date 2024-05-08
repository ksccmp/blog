package com.jforj.abstractfactory.beforefactorymethod.button;

public class SafariButton implements BrowserButton {

    @Override
    public void print() {
        System.out.println("safari button create");
    }
}
