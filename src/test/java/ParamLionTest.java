import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParamLionTest {

    private String sex ;
    private boolean expectedResult;

    public ParamLionTest(String sex, boolean expectedResult){
        this.sex = sex;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] getLionMane() {
        return new Object[][]{
            {"Самец", true},
            {"Самка", false}
        };
    }

    @Test
    public void lionHasManeTest() throws Exception {
        Lion lion = new Lion(sex);
        boolean result = lion.doesHaveMane();
        assertEquals(expectedResult, result);
    }

}
