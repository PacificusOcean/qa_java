import com.example.Lion;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import com.example.Feline;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class LionParameterizedTests {
    private static Stream<Arguments> provideSexAndMane() {
        return Stream.of(
                Arguments.of("Самец", true),
                Arguments.of("Самка", false)
        );
    }


    @ParameterizedTest
    @MethodSource("provideSexAndMane")



    void testConstructor(String sex, boolean expectedMane) throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        Lion lion = new Lion(sex, mockFeline);
        assertEquals(expectedMane, lion.doesHaveMane());
    }

    @Test
    void testConstructor_InvalidSex() {
        Feline mockFeline = Mockito.mock(Feline.class);
        Exception exception = assertThrows(Exception.class, () -> new Lion("Неправильный пол", mockFeline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
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
        Mockito.when(mockFeline.getFood("Хищник")).thenReturn(Arrays.asList("Зебра", "Антилопа"));
        Lion lion = new Lion("Самец", mockFeline);
        List<String> food = lion.getFood("Хищник");
        assertEquals(4, food.size());
        assertTrue(food.contains("Животные"));
        assertTrue(food.contains("Птицы"));
        assertTrue(food.contains("Рыба"));
    }


}
