package com.jforj.abstractfactory.beforefactorymethod.button;

public class ChromeButtonFacotry implements BrowserButtonFactory {

    @Override
    public BrowserButton createButton() {
        return new ChromeButton();
    }
}
