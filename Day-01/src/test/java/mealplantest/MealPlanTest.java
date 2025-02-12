package mealplantest;

import com.generics.personalizedmealplangenerator.*;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MealPlanTest {

    private final ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    // Method to capture the System.out output
    private String getConsoleOutput(Meal<? extends MealPlan> meal) {
        // Redirect System.out to capture output
        System.setOut(new PrintStream(capturedOut));
        meal.generateMealPlan();
        System.setOut(originalOut);  // Reset System.out to its original state
        return capturedOut.toString().trim();  // Return the captured output
    }



    @Test
    public void testVegetarianMeal() {
        Meal<VegetarianMeal> vegetarianMeal = MealPlanGenerator.createMealPlan(new VegetarianMeal());
        String expectedOutput = "Vegetarian Meal: Grilled vegetables with quinoa.";
        assertEquals(expectedOutput, getConsoleOutput(vegetarianMeal));
    }

    @Test
    public void testVeganMeal() {
        Meal<VeganMeal> veganMeal = MealPlanGenerator.createMealPlan(new VeganMeal());
        String expectedOutput = "Vegan Meal: Tofu stir-fry with brown rice.";
        assertEquals(expectedOutput, getConsoleOutput(veganMeal));
    }

    @Test
    public void testKetoMeal() {
        Meal<KetoMeal> ketoMeal = MealPlanGenerator.createMealPlan(new KetoMeal());
        String expectedOutput = "Keto Meal: Grilled salmon with avocado salad.";
        assertEquals(expectedOutput, getConsoleOutput(ketoMeal));
    }

    @Test
    public void testHighProteinMeal() {
        Meal<HighProteinMeal> highProteinMeal = MealPlanGenerator.createMealPlan(new HighProteinMeal());
        String expectedOutput = "High-Protein Meal: Chicken breast with sweet potatoes.";
        assertEquals(expectedOutput, getConsoleOutput(highProteinMeal));
    }


}

