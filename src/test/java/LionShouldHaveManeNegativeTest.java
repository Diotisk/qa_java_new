import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

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

    @Parameterized.Parameters
    public static Object[] getHasManeData() {
        return new Object[][]{
                {"Непонятно", expectedException},
                {"Samka", expectedException},
        };
    }

    @Test(expected=Exception.class)
    public void shouldHaveManePositiveResult() throws Exception {
        Lion lion = new Lion(feline, this.sex);
        lion.doesHaveMane();
    }
}



