import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class LionTest {

    @Test
    void testConstructor_ValidSex() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Lion lion = new Lion("Самец", mockFeline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void testConstructor_InvalidSex() {
        Feline mockFeline = Mockito.mock(Feline.class);
        Exception exception = assertThrows(Exception.class, () -> new Lion("Неправильный пол", mockFeline));
        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }

    @Test
    void testGetKittens() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Mockito.when(mockFeline.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", mockFeline);
        assertEquals(1, lion.getKittens());
    }


    @Test
    void testGetFood() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Mockito.when(mockFeline.getFood("Хищник")).thenReturn(Arrays.asList("Зебра", "Антилопа", "Еще один элемент"));
        Lion lion = new Lion("Самец", mockFeline);
        List<String> food = lion.getFood("Хищник");
        assertEquals(4, food.size()); // Проверяем размер списка


    }

    @Test
    void testDoesHaveMane() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Lion lion = new Lion("Самец", mockFeline);
        assertTrue(lion.doesHaveMane());

        Lion lion2 = new Lion("Самка", mockFeline);
        assertFalse(lion2.doesHaveMane());
    }
}