package com.jforj.abstractfactory.after;

import com.jforj.abstractfactory.after.button.BrowserButton;
import com.jforj.abstractfactory.after.textfield.BrowserTextField;

public class Main {
    public static void main(String[] args) {
        // chrome
        renderBrowserComponent(new ChromeFactory());

        // edge
        renderBrowserComponent(new EdgeFactory());

        // safari
        renderBrowserComponent(new SafariFactory());
    }

    public static void renderBrowserComponent(BrowserFactory browserFactory) {
        BrowserButton edgeButton = browserFactory.createButton();
        BrowserTextField edgeTextField = browserFactory.createTextField();
        edgeButton.print();
        edgeTextField.print();
    }
}
