package com.jforj.abstractfactory.beforefactorymethod.button;

public class ChromeButonFacotry implements BrowserButtonFactory {

    @Override
    public BrowserButton createBrowserButton() {
        return new ChromeButton();
    }
}
