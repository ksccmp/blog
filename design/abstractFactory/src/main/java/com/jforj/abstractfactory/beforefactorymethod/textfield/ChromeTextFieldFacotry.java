package com.jforj.abstractfactory.beforefactorymethod.textfield;

public class ChromeTextFieldFacotry implements BrowserTextFieldFactory {

    @Override
    public BrowserTextField createTextField() {
        return new ChromeTextField();
    }
}
