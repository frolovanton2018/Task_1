package praktikum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BunTest {

    @Test
    void getNameReturnsCorrectBunName() {
        Bun bun = new Bun("Бриошь", 80.0f);
        String name = bun.getName();
        assertEquals("Бриошь", name);
    }

    @Test
    void getPriceReturnsCorrectBunPrice() {
        Bun bun = new Bun("Кунжутная", 60.0f);
        float price = bun.getPrice();
        assertEquals(60.0f, price);
    }

    @Test
    void bunConstructorSetsNameCorrectly() {
        Bun bun = new Bun("Чиабатта", 70.0f);
        assertEquals("Чиабатта", bun.name);
    }

    @Test
    void bunConstructorSetsPriceCorrectly() {
        Bun bun = new Bun("Пшеничная", 55.0f);
        assertEquals(55.0f, bun.price);
    }

    @Test
    void getNameWithEmptyNameReturnsEmptyString() {
        Bun bun = new Bun("", 100.0f);
        assertEquals("", bun.getName());
    }

    @Test
    void getPriceWithZeroPriceReturnsZero() {
        Bun bun = new Bun("Бесплатная", 0.0f);
        assertEquals(0.0f, bun.getPrice());
    }
}
