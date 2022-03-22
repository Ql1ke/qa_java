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
        Lion lion = new Lion("Самец", feline);
        boolean expectedMane = true;
        boolean actualMane = lion.doesHaveMane();
        assertEquals(expectedMane, actualMane);
    }

    @Test
    public void doesNotManeTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        boolean expectedMane = false;
        boolean actualMane = lion.doesHaveMane();
        assertEquals(expectedMane, actualMane);
    }

//    // Проверка, что выбрасывается исключение
//    @Test(expected = Exception.class)
//    public void lionExceptionTest() throws Exception {
//      Lion lion = new Lion("Оно", feline);
//      String expectedString = "Используйте допустимые значения пола животного - самей или самка";
//    }

//    //Проверка, что выбрасывает определённый текст исключения
//    @Test
//    public void lionExceptionStringTest() throws Exception {
//        try {
//            Lion lion = new Lion("Оно", feline);
//        } catch (Exception e) {
//            String expectedString = "Используйте допустимые значения пола животного - самей или самка";
//            assertEquals(expectedString, e.getMessage());
//        }

    //Заменил 2 теста на исключения - одним тестом через Rule
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void exceptionTest() throws Exception {
        String expectedString = "Используйте допустимые значения пола животного - самей или самка";
        thrown.expect(Exception.class);
        thrown.expectMessage(expectedString);
        Lion lion = new Lion("Оно", feline);
    }

    @Test
    public void getKittensTest() throws Exception {
        thrown.expect(StackOverflowError.class);
        Lion lion = new Lion("Самец", feline);
        lion.getKittens();
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> animal = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(animal);
        List<String> actualMeat = lion.getFood();
        List<String> expectedMeat = animal;
        assertEquals(expectedMeat, actualMeat);
    }


}




