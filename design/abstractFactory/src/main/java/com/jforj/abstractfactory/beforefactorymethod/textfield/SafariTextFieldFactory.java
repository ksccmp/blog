package com.jforj.abstractfactory.beforefactorymethod.textfield;

public class EdgeTextFieldFactory implements BrowserTextFieldFactory {

    @Override
    public BrowserTextField createTextField() {
        return new EdgeTextField();
    }
}
