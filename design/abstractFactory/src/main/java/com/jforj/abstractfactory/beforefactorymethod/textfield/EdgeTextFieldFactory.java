package com.jforj.abstractfactory.beforefactorymethod.button;

public class EdgeButtonFactory implements BrowserButtonFactory {

    @Override
    public BrowserButton createBrowserButton() {
        return new EdgeButton();
    }
}
