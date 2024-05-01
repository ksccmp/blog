package com.jforj.decorator.beforeextend;

import java.util.List;

public class BulgogiBurger extends Burger {
    public BulgogiBurger() {
        super(2500, List.of("Patty", "Bread", "Bulgogi"));
    }
}
