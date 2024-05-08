package com.jforj.abstractfactory.after.textfield;

public class ChromeTextField implements BrowserTextField {

    @Override
    public void print() {
        System.out.println("chrome text field create");
    }
}
