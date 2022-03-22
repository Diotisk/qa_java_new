import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void doesHaveManeMaleLionTest() throws Exception {
        Lion lionMale = new Lion(feline, "Самец");
        assertTrue(lionMale.doesHaveMane());
    }

    @Test
    public void doesHaveManeFemaleLionTest() throws Exception {
        Lion lionFemale = new Lion(feline, "Самка");
        assertFalse(lionFemale.doesHaveMane());
    }

    @Test
    public void getKittensTestPositiveResult() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        when(feline.getKittens()).thenReturn(1);
        int expected = 1;
        int actual = lion.getKittens();
        assertEquals("Метод должен возвращать 1", expected, actual);
    }

    @Test
    public void getKittensTestNegativeResult() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        when(feline.getKittens()).thenReturn(0);
        int expected = 1;
        int actual = lion.getKittens();
        assertNotEquals("Метод должен возвращать 1", expected, actual);
    }

    @Test
    public void getFoodTestPositiveResult() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = lion.getFood();
        assertEquals("Метод должен возвращать питание хищников", expected, actual);
    }

    @Test
    public void getFoodTestNegativeResult() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        when(feline.eatMeat()).thenReturn(List.of("Трава", "Грибы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = lion.getFood();
        assertNotEquals("Метод должен возвращать питание хищников", expected, actual);
    }
}

