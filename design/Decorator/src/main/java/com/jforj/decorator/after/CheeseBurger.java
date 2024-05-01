package com.jforj.decorator.after;

import java.util.List;

public class CheeseBurger implements Burger {

    @Override
    public long getCost() {
        return 1500;
    }

    @Override
    public List<String> getIngredients() {
        return List.of("Patty", "Bread", "Cheese");
    }
}
