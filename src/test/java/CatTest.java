import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void catTest() throws Exception {
        List<String> animal = List.of("Животные", "Птицы", "Рыба");
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(animal);
        List<String> actual = cat.getFood();
        List<String> expected = animal;
        assertEquals(expected, actual);
    }

    @Test
    public void getSoundTest() {
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }



}
