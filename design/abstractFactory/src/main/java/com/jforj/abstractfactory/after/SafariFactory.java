package com.jforj.abstractfactory.after;

import com.jforj.abstractfactory.after.button.BrowserButton;
import com.jforj.abstractfactory.after.button.EdgeButton;
import com.jforj.abstractfactory.after.textfield.BrowserTextField;
import com.jforj.abstractfactory.after.textfield.EdgeTextField;

public class EdgeFactory implements BrowserFactory {

    @Override
    public BrowserButton createButton() {
        return new EdgeButton();
    }

    @Override
    public BrowserTextField createTextField() {
        return new EdgeTextField();
    }
}
