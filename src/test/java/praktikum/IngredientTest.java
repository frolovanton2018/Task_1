package praktikum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {

    @Test
    void getNameReturnsCorrectName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Томатный", 50.0f);
        String name = ingredient.getName();
        assertEquals("Томатный", name);
    }

    @Test
    void getPriceReturnsCorrectPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Котлета", 200.0f);
        float price = ingredient.getPrice();
        assertEquals(200.0f, price);
    }

    @Test
    void constructorSetsAllFields() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Сыр", 100.0f);
        assertEquals(IngredientType.FILLING, ingredient.type);
        assertEquals("Сыр", ingredient.name);
        assertEquals(100.0f, ingredient.price);
    }

    @Test
    void getPriceForSauceReturnsCorrectValue() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Майонез", 25.0f);
        float price = ingredient.getPrice();
        assertEquals(25.0f, price);
    }

    @Test
    void getNameForFilledReturnsCorrectValue() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Бекон", 150.0f);
        String name = ingredient.getName();
        assertEquals("Бекон", name);
    }

    @Test
    void getTypeReturnsFillingForFillingIngredient() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Говядина", 180.0f);
        IngredientType type = ingredient.getType();
        assertEquals(IngredientType.FILLING, type);
    }

    @Test
    void getTypeReturnsSauceForSauceIngredient() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Кетчуп", 20.0f);
        IngredientType type = ingredient.getType();
        assertEquals(IngredientType.SAUCE, type);
    }
}
