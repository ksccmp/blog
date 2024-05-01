package com.jforj.decorator.beforeextend;

import java.util.List;
import java.util.stream.Stream;

public abstract class Burger {
    private long cost;
    private List<String> ingredients;

    protected Burger(long cost, List<String> ingredients) {
        this.cost = cost;
        this.ingredients = ingredients;
    }

    protected void addIngredient(String ingredientType) {
        switch (ingredientType) {
            case "sauce": {
                this.cost += 500;
                this.ingredients = Stream.concat(this.ingredients.stream(), List.of("Sauce").stream()).toList();
                break;
            }

            case "lettuce": {
                this.cost += 1000;
                this.ingredients = Stream.concat(this.ingredients.stream(), List.of("Lettuce").stream()).toList();
                break;
            }
        }
    }

    protected long getCost() {
        return this.cost;
    }

    protected List<String> getIngredients() {
        return this.ingredients;
    }
}
