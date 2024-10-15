import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class FelineTest {


    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.eatMeat();
        assertNotNull(food, "Метод eatMeat должен вернуть непустой список еды");
        assertEquals(3, food.size(), "Метод eatMeat должен вернуть список с одним элементом 'Хищник'");
        assertEquals("Животные", food.get(0), "Первый элемент в списке должен быть 'Хищник'");
    }

    @Test
    void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void testGetKittens() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    void testGetKittens_WithCount() {
        Feline feline = new Feline();
        assertEquals(3, feline.getKittens(3));



    }
}