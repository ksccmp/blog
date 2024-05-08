package com.jforj.abstractfactory.after;

import com.jforj.abstractfactory.after.button.BrowserButton;
import com.jforj.abstractfactory.after.textfield.BrowserTextField;

public interface BrowserFactory {

    BrowserButton createButton();

    BrowserTextField createTextField();
}
