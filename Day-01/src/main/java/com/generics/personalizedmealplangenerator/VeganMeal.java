package com.generics.personalizedmealplangenerator;

public class VeganMeal implements MealPlan {
    @Override
    public void displayMeal() {
        System.out.println("Vegan Meal: Tofu stir-fry with brown rice.");
    }
}