package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;

import java.util.List;

class LionTest {

    @Test
    void testLionConstructor_Male() throws Exception {
        Lion lion = new Lion("Самец");
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void testLionConstructor_Female() throws Exception {
        Lion lion = new Lion("Самка");
        assertFalse(lion.doesHaveMane());
    }

    @Test
    void testLionConstructor_InvalidSex() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Неизвестный пол"));
        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }

    @Test
    void testGetKittens() {
        Lion lion = new Lion("Самец");
        assertEquals(1, lion.getKittens());
    }

    @Test
    void testGetFood() throws Exception {
        // Создаем имитацию Feline
        Feline mockFeline = Mockito.mock(Feline.class);
        List<String> expectedFood = List.of("Мясо", "Кости");
        Mockito.when(mockFeline.getFood("Хищник")).thenReturn(expectedFood);

        // Создаем Lion с имитацией Feline
        Lion lion = new Lion("Самец", mockFeline);

        // Вызываем getFood() и проверяем результат
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
    }
}
