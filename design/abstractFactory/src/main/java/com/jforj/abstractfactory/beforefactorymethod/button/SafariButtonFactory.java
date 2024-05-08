package com.jforj.abstractfactory.beforefactorymethod.button;

public class SafariButtonFactory implements BrowserButtonFactory {

    @Override
    public BrowserButton createButton() {
        return new SafariButton();
    }
}
