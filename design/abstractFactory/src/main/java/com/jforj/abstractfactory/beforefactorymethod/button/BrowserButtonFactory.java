package com.jforj.abstractfactory.beforefactorymethod.button;

public interface BrowserButtonFactory {

    default BrowserButton getInstance() {
        return createButton();
    }

    BrowserButton createButton();
}
