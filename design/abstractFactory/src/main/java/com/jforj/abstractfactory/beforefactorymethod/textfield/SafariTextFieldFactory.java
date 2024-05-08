package com.jforj.abstractfactory.beforefactorymethod.textfield;

public class SafariTextFieldFactory implements BrowserTextFieldFactory {

    @Override
    public BrowserTextField createTextField() {
        return new SafariTextField();
    }
}
