package com.jforj.abstractfactory.beforefactorymethod.button;

public class EdgeButtonFactory implements BrowserButtonFactory {

    @Override
    public BrowserButton createButton() {
        return new EdgeButton();
    }
}
