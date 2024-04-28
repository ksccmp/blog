package com.jforj.abstractfactory.after;

public class EdgeTextField implements BrowserTextField {

    @Override
    public void print() {
        System.out.println("edge text field create");
    }
}
