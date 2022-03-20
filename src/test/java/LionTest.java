import com.example.Animal;
import com.example.Feline;
import com.example.Lion;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void doesManeTest() throws Exception {
        Lion lion = new Lion("Самец");
        boolean expectedMane = true;
        boolean actualMane = lion.doesHaveMane();
        assertEquals(expectedMane, actualMane);
    }

    @Test
    public void doesNotManeTest() throws Exception {
        Lion lion = new Lion("Самка");
        boolean expectedMane = false;
        boolean actualMane = lion.doesHaveMane();
        assertEquals(expectedMane, actualMane);
    }

    @Test(expected = Exception.class)
    public void lionExceptionTest() throws Exception {
        Lion lion = new Lion("Оно");
    }

    @Test
    public void lionExceptionStringTest() throws Exception {
        try {
            Lion lion = new Lion("Оно");
        } catch (Exception e) {
            String expectedString = "Используйте допустимые значения пола животного - самей или самка";
            assertEquals(expectedString, e.getMessage());
        }
    }


    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самец");
        List<String> expectedMeat = lion.getFood("Хищник");
        List<String> actualMeat = lion.getFood();
        assertEquals(expectedMeat, actualMeat);
    }
}




