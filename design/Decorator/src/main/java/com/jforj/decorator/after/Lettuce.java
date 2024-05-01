package com.jforj.decorator.after;

import java.util.List;
import java.util.stream.Stream;

public class Lettuce extends BurgerDecorator {

    public Lettuce(Burger burger) {
        super(burger);
    }

    @Override
    public long getCost() {
        return super.burger.getCost() + 1000;
    }

    @Override
    public List<String> getIngredients() {
        return Stream.concat(super.burger.getIngredients().stream(), List.of("Lettuce").stream()).toList();
    }
}
