package com.jforj.abstractfactory.after;

import com.jforj.abstractfactory.after.button.BrowserButton;
import com.jforj.abstractfactory.after.button.ChromeButton;
import com.jforj.abstractfactory.after.textfield.BrowserTextField;
import com.jforj.abstractfactory.after.textfield.ChromeTextField;

public class ChromeFactory implements BrowserFactory {

    @Override
    public BrowserButton createButton() {
        return new ChromeButton();
    }

    @Override
    public BrowserTextField createTextField() {
        return new ChromeTextField();
    }
}
