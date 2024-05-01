package com.jforj.decorator.beforeextend;

public class Main {
    public static void main(String[] args) {
        // 치즈버거 기본
        Burger cheeseBurger = new CheeseBurger();
        System.out.println("cost= " + cheeseBurger.getCost() + ", ingredients= " + cheeseBurger.getIngredients());

        // 치즈버거 소스 추가
        Burger addSaucecheeseBurger = new CheeseBurger();
        addSaucecheeseBurger.addIngredient("sauce");
        System.out.println("cost= " + addSaucecheeseBurger.getCost() + ", ingredients= " + addSaucecheeseBurger.getIngredients());

        // 불고기버거 기본
        Burger bulgogiBurger = new BulgogiBurger();
        System.out.println("cost= " + bulgogiBurger.getCost() + ", ingredients= " + bulgogiBurger.getIngredients());

        // 불고기버서 양상추, 소스 추가
        Burger addLettuceAndSauceBulgogiBurger = new BulgogiBurger();
        addLettuceAndSauceBulgogiBurger.addIngredient("lettuce");
        addLettuceAndSauceBulgogiBurger.addIngredient("sauce");
        System.out.println("cost= " + addLettuceAndSauceBulgogiBurger.getCost() + ", ingredients= " + addLettuceAndSauceBulgogiBurger.getIngredients());
    }
}
