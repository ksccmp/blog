package com.jforj.abstractfactory.beforenodesign;

public class BrowserComponent {

    public void createButton(String type) {
        switch (type) {
            case "chrome": {
                System.out.println("chrome button create");
                break;
            }

            case "edge": {
                System.out.println("edge button create");
                break;
            }

            case "safari": {
                System.out.println("safari button create");
                break;
            }

            default: {
                System.out.println("do not create button");
            }
        }
    }

    public void createTextField(String type) {
        switch (type) {
            case "chrome": {
                System.out.println("chrome text field create");
                break;
            }

            case "edge": {
                System.out.println("edge text field create");
                break;
            }

            case "safari": {
                System.out.println("safari text field create");
                break;
            }

            default: {
                System.out.println("do not create text field");
            }
        }
    }
}
