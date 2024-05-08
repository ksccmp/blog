package com.jforj.abstractfactory.after;

import com.jforj.abstractfactory.after.button.BrowserButton;
import com.jforj.abstractfactory.after.button.SafariButton;
import com.jforj.abstractfactory.after.textfield.BrowserTextField;
import com.jforj.abstractfactory.after.textfield.SafariTextField;

public class SafariFactory implements BrowserFactory {

    @Override
    public BrowserButton createButton() {
        return new SafariButton();
    }

    @Override
    public BrowserTextField createTextField() {
        return new SafariTextField();
    }
}
