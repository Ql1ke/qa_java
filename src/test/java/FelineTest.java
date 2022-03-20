import com.example.Feline;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {



    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensTest() {
        int expectedCount = 1;
        Feline feline = new Feline();
        assertEquals(expectedCount, feline.getKittens());
    }

    @Test
    public void getKittensCountTest() {
        int expectedCount = 3;
        Feline feline = new Feline();
        assertEquals(expectedCount, feline.getKittens(expectedCount));
    }

    @Test
    public void eatMeatTest() throws Exception {
        Feline feline = new Feline();
        List<String> expectedMeat = List.of("Животные", "Птицы", "Рыба");
        List<String> actualMeat = feline.eatMeat();
        assertEquals(expectedMeat, actualMeat);
    }


}



