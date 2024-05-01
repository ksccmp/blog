package com.jforj.decorator.after;

import java.util.List;

public class BulgogiBurger implements Burger {

    @Override
    public long getCost() {
        return 2500;
    }

    @Override
    public List<String> getIngredients() {
        return List.of("Patty", "Bread", "Bulgogi");
    }
}
