

import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(MockitoJUnitRunner.class)
class CatTest {
    @Mock

    private Cat cat;
    private Feline mockFeline;


    @BeforeEach
    public void setUp() {
        mockFeline = Mockito.mock(Feline.class);
        cat = new Cat(mockFeline);
    }

    @Test
    public void testGetSound() {
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();
        assertEquals(expectedSound, actualSound, "Звук кота должен быть 'Мяу'");
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Мясо", "Рыба");
        Mockito.when(mockFeline.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();

        assertEquals(expectedFood, actualFood, "Кот должен есть мясо и рыбу");
    }

    @Test
    public void testGetFoodThrowsException() throws Exception {
        Mockito.when(mockFeline.eatMeat()).thenThrow(new Exception("Ошибка"));

        assertThrows(Exception.class, () -> cat.getFood(), "Метод getFood должен выбросить исключение");
    }
}