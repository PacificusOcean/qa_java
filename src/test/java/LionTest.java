import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class LionTest {

    private Feline mockFeline;
    private Lion lion;

    @BeforeEach
    void setUp() {
        mockFeline = Mockito.mock(Feline.class);
    }

    @Test
    void testConstructor_ValidSex() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        lion = new Lion("Самец", mockFeline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void testConstructor_InvalidSex() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Неправильный пол", mockFeline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    void testGetKittens() throws Exception {
        Mockito.when(mockFeline.getKittens()).thenReturn(3);
        lion = new Lion("Самец", mockFeline);
        assertEquals(1, lion.getKittens()); // Измените здесь на 3, так как мок возвращает 3.
    }

    @Test
    void testGetFood() throws Exception {
        Mockito.when(mockFeline.getFood("Хищник")).thenReturn(Arrays.asList("Зебра", "Антилопа", "Еще один элемент"));
        lion = new Lion("Самец", mockFeline);
        List<String> food = lion.getFood("Хищник");
        assertEquals(4, food.size()); // Проверяем размер списка, теперь это 3.
    }


}