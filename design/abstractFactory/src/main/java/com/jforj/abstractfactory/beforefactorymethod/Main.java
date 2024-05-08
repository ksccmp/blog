package com.jforj.abstractfactory.beforefactorymethod;

import com.jforj.abstractfactory.beforefactorymethod.button.BrowserButton;
import com.jforj.abstractfactory.beforefactorymethod.button.ChromeButtonFacotry;
import com.jforj.abstractfactory.beforefactorymethod.button.EdgeButtonFactory;
import com.jforj.abstractfactory.beforefactorymethod.button.SafariButtonFactory;
import com.jforj.abstractfactory.beforefactorymethod.textfield.BrowserTextField;
import com.jforj.abstractfactory.beforefactorymethod.textfield.ChromeTextFieldFacotry;
import com.jforj.abstractfactory.beforefactorymethod.textfield.EdgeTextFieldFactory;
import com.jforj.abstractfactory.beforefactorymethod.textfield.SafariTextFieldFactory;

public class Main {
    public static void main(String[] args) {
        // chrome
        BrowserButton chromeButton = new ChromeButtonFacotry().getInstance();
        BrowserTextField chromeTextField = new ChromeTextFieldFacotry().getInstance();
        chromeButton.print();
        chromeTextField.print();

        // edge
        BrowserButton edgeButton = new EdgeButtonFactory().getInstance();
        BrowserTextField edgeTextField = new EdgeTextFieldFactory().getInstance();
        edgeButton.print();
        edgeTextField.print();

        // safari
        BrowserButton safariButton = new SafariButtonFactory().getInstance();
        BrowserTextField safariTextField = new SafariTextFieldFactory().getInstance();
        safariButton.print();
        safariTextField.print();
    }
}
