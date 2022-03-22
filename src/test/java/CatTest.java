import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSoundTestPositiveResult() {
        Cat cat = new Cat(feline);
        String expected = "Мяу";
        String actual = cat.getSound();
        assertEquals("Метод должен возвращать мяу", expected, actual);
    }

    @Test
    public void getFoodTestPositiveResult() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = cat.getFood();
        assertEquals("Метод должен возвращать питание хищников", expected, actual);
    }

    @Test
    public void getFoodTestNegativeResult() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Трава", "Грибы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = cat.getFood();
        assertNotEquals("Метод должен возвращать питание хищников", expected, actual);
    }

}

