import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionShouldHaveManePositiveTest {

    @Mock
    Feline feline;

    private final String sex;
    private final boolean expectedHasMane;


    public LionShouldHaveManePositiveTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Object[] getHasManeData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void shouldHaveManePositiveResult() throws Exception {
        Lion lion = new Lion(feline, this.sex);
        boolean actualHasMane = lion.doesHaveMane();
        boolean expectedHasMane = this.expectedHasMane;
        assertEquals(actualHasMane, expectedHasMane);
    }
}


