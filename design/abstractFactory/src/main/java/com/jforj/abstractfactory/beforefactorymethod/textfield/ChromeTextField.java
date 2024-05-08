package com.jforj.abstractfactory.beforefactorymethod.textfield;

public class ChromeTextField implements BrowserTextField {

    @Override
    public void print() {
        System.out.println("chrome text field create");
    }
}
