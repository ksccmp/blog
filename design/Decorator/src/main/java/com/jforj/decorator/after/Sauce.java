package com.jforj.decorator.after;

import java.util.List;
import java.util.stream.Stream;

public class Sauce extends BurgerDecorator {

    public Sauce(Burger burger) {
        super(burger);
    }

    @Override
    public long getCost() {
        return super.burger.getCost() + 500;
    }

    @Override
    public List<String> getIngredients() {
        return Stream.concat(super.burger.getIngredients().stream(), List.of("Sauce").stream()).toList();
    }
}
