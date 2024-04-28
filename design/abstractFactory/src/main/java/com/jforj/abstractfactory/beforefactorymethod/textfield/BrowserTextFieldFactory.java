package com.jforj.abstractfactory.beforefactorymethod.button;

public interface BrowserButtonFactory {

    default BrowserButton getInstance() {
        BrowserButton browserButton = createBrowserButton();
        browserButton.print();

        return browserButton;
    }

    BrowserButton createBrowserButton();
}
