package com.jforj.decorator.beforebase;

import java.util.List;
import java.util.stream.Stream;

public class Burger {

    private String type;
    private long cost;
    private List<String> ingredients;

    public Burger(String type, long cost, List<String> ingredients) {
        this.type = type;
        this.cost = cost;
        this.ingredients = ingredients;
    }

    public void addIngredient(String ingredientType) {
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

    public long getCost() {
        return this.cost;
    }

    public List<String> getIngredients() {
        return this.ingredients;
    }
}
