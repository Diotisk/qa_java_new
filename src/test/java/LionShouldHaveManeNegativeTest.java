import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class LionShouldHaveManeNegativeTest {

    @Mock
    Feline feline;

    private final String sex;
    private static Exception expectedException = new Exception();

    public LionShouldHaveManeNegativeTest(String sex, Exception expectedException) {
        this.sex = sex;
        this.expectedException = expectedException;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[] getHasManeData() {
        return new Object[][]{
                {"Непонятно", expectedException},
                {"Samka", expectedException},
        };
    }

    @Test
    public void shouldHaveManePositiveResult() {
        Exception ex = assertThrows(Exception.class, () -> {
            Lion lion = new Lion(feline, this.sex);
            lion.doesHaveMane();
        });

        String expectedExceptionMessage = "Используйте допустимые значения пола животного - самец или самка";
        String actualExceptionMessage = ex.getMessage();

        assertTrue(actualExceptionMessage.contains(expectedExceptionMessage));
    }
}