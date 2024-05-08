package com.jforj.abstractfactory.after.textfield;

public class SafariTextField implements BrowserTextField {

    @Override
    public void print() {
        System.out.println("safari text field create");
    }
}
