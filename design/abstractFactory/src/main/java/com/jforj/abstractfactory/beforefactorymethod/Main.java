package com.jforj.abstractfactory.beforenodesign;

public class Main {
    public static void main(String[] args) {
        BrowserComponent browserComponent = new BrowserComponent();

        // chrome
        String chromeType = "chrome";
        browserComponent.createButton(chromeType);
        browserComponent.createTextField(chromeType);

        // edge
        String edgeType = "edge";
        browserComponent.createButton(edgeType);
        browserComponent.createTextField(edgeType);
    }
}
