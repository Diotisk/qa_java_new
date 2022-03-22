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
public class FelineTest {

    @Mock
    Feline feline;

    @Test
    public void eatMeatTestPositiveResult() throws Exception {
        Feline feline = new Feline();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        assertEquals("Метод должен возвращать питание хищников", expected, actual);
    }

    @Test
    public void getFoodTest() throws Exception{
        feline.getFood("Хищник");
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    public void getFamilyTestPositiveResult() {
        Feline feline = new Feline();
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals("Метод должен возвращать семейство кошачьих", expected, actual);
    }

    @Test
    public void getKittensTestPositiveResult() {
        Feline feline = new Feline();
        int expected = 1;
        int actual = feline.getKittens();
        assertEquals("Метод должен возвращать 1", expected, actual);
    }

    @Test
    public void getKittensTestNegativeResult() {
        Feline feline = new Feline();
        int expected = 0;
        int actual = feline.getKittens();
        assertNotEquals("Метод должен возвращать 1", expected, actual);
    }

    @Test
    public void getKittensCountTestPositiveResult() {
        Feline feline = new Feline();
        int kittensCount = 10;
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }

}

