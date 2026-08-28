package praktikum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BurgerTest {

    @Test
    void setBunsSetsBunCorrectly() {
        Burger burger = new Burger();
        Bun bun = new Bun("Бриошь", 80.0f);
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    void addIngredientAddsToCollection() {
        Burger burger = new Burger();
        Burger mockBurger = spy(burger);
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Томатный", 50.0f);
        mockBurger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    void removeIngredientRemovesFromCollection() {
        Burger burger = new Burger();
        burger.bun = new Bun("Кунжутная", 80.0f);
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "Томатный", 50.0f);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "Котлета", 200.0f);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    void getPriceReturnsCorrectTotalPrice() {
        Burger burger = new Burger();
        Bun bun = new Bun("Бриошь", 100.0f);
        burger.setBuns(bun);
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Майонез", 50.0f);
        burger.addIngredient(ingredient);
        float price = burger.getPrice();
        assertEquals(250.0f, price);
    }

    @Test
    void getPriceWithMultipleIngredientsReturnsCorrectTotalPrice() {
        Burger burger = new Burger();
        Bun bun = new Bun("Чиабатта", 90.0f);
        burger.setBuns(bun);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "Барбекю", 30.0f);
        Ingredient filling = new Ingredient(IngredientType.FILLING, "Говядина", 200.0f);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        float price = burger.getPrice();
        assertEquals(410.0f, price);
    }

    @Test
    void moveIngredientMovesIngredientToNewPosition() {
        Burger burger = new Burger();
        burger.bun = new Bun("Бриошь", 80.0f);
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "Кетчуп", 20.0f);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "Сыр", 100.0f);
        Ingredient ingredient3 = new Ingredient(IngredientType.FILLING, "Бекон", 150.0f);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.moveIngredient(0, 2);
        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals(ingredient3, burger.ingredients.get(1));
        assertEquals(ingredient1, burger.ingredients.get(2));
    }

    @Test
    void getReceiptReturnsFormattedString() {
        Burger burger = new Burger();
        Bun bun = new Bun("Кунжутная", 80.0f);
        burger.setBuns(bun);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "Майонез", 40.0f);
        burger.addIngredient(sauce);
        String receipt = burger.getReceipt();
        assertTrue(receipt.contains("Кунжутная"));
        assertTrue(receipt.contains("sauce"));
        assertTrue(receipt.contains("Майонез"));
        assertTrue(receipt.contains("Price:"));
    }

    @Test
    void getPriceWithNoIngredientsReturnsBunPriceDouble() {
        Burger burger = new Burger();
        Bun bun = new Bun("Пшеничная", 70.0f);
        burger.setBuns(bun);
        float price = burger.getPrice();
        assertEquals(140.0f, price);
    }
}
