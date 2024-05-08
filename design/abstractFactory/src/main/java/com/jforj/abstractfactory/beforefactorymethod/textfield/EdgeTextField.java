package com.jforj.abstractfactory.beforefactorymethod.textfield;

public class EdgeTextField implements BrowserTextField {

    @Override
    public void print() {
        System.out.println("edge text field create");
    }
}
