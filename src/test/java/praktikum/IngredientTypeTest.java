package praktikum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTypeTest {

    @ParameterizedTest
    @ValueSource(strings = {"SAUCE", "FILLING"})
    void valueOfTypeReturnsCorrectType(String ingredientType) {
        IngredientType type = IngredientType.valueOf(ingredientType);
        assertNotNull(type);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void valuesReturnsAllTypes(int index) {
        IngredientType[] types = IngredientType.values();
        assertEquals(2, types.length);
        assertNotNull(types[index]);
    }
}
