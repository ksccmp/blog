package com.jforj.abstractfactory.beforefactorymethod.textfield;

public class SafariTextField implements BrowserTextField {

    @Override
    public void print() {
        System.out.println("safari text field create");
    }
}
