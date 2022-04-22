import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalParamTest {

    private final String food;
    private final List<String> expectedResult;

    public AnimalParamTest(String food, List<String> expectedResult) {
        this.food = food;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] getFoodData() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}

        };
    }

    @Test
    public void getFoodAnimalTest() throws Exception {
        Animal animal = new Animal();
        List<String> result = animal.getFood(food);
        assertEquals(expectedResult, result);
    }

}
