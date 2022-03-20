import com.example.Feline;
import com.example.Lion;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParamTest {

    private final String hasMane;
    private final String expected;

    public LionParamTest(boolean hasMane, String expectedText) {
        this.hasMane = String.valueOf(hasMane);
        this.expected = expectedText;
    }

//    @Parameterized.Parameters
//    public static Object[][] getTextData() {
//        return new Object[][] {
//                {"Травоядное", "[Трава, Различные растения]"},
//                {"Хищник", "[Животные, Птицы, Рыба]"},
//        };
//    }

//    @Test
//    public void getFoodAnimalTest() throws Exception {
//        Feline feline = new Feline();
//        String actual = String.valueOf(feline.getFood(checkText));
//        assertEquals(expected, actual);
//    }

    @Parameterized.Parameters
    public static Object[][] testLionConstructorData() { // источник данных для метода, возвращает двумерный массив
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}

        };
    }

    Feline feline;

    @Test
    public void testLionConstructor () throws Exception {
        Lion lion = new Lion(hasMane, feline);
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void getFoodLionExceptionTest() throws Exception {
        Lion lion = new Lion(hasMane, feline);
        thrown.expect(Exception.class);
        thrown.expectMessage("Неизвестный вид животного, используйте значение Травоядное или Хищник");
//        List<String> actual = lion.getFood();
    }



}
