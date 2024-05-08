package com.jforj.abstractfactory.beforefactorymethod.textfield;

public interface BrowserTextFieldFactory {

    default BrowserTextField getInstance() {
        return createTextField();
    }

    BrowserTextField createTextField();
}
