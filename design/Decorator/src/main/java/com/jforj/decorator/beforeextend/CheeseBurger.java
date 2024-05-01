package com.jforj.decorator.beforeextend;

import java.util.List;

public class CheeseBurger extends Burger {
    public CheeseBurger() {
        super(1500, List.of("Patty", "Bread", "Cheese"));
    }
}
