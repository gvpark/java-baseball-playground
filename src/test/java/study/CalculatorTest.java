package study;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    Calculator cal;

    
    @BeforeEach
    public void setUp(){
        cal = new Calculator();
    }
    
    @DisplayName("덧셈 테스트")
    @Test
    public void 덧셈(){
        assertEquals(7, cal.add(3,4));
    }
    
    @DisplayName("뺄셈 테스트")
    @Test
    public void 뺄셈(){
        assertEquals(1,cal.subtract(5,4));
    }

    @DisplayName("곱셈 테스트")
    @Test
    public void 곱셉(){
        assertEquals(12, cal.multiply(2,6));
    }

    @DisplayName("나눗셈 테스트")
    @Test
    public void 나눗셈(){
        assertEquals(2, cal.divide(6,3));
    }
    @AfterEach
    public void tearDown(){
        cal = null;
    }

    @Before
    public void setup(){
        System.out.println("setup");
    }

    @Test
    public void test1() throws Exception{
        System.out.println("test1");
    }

    @Test
    public void test2() throws Exception{
        System.out.println("test2");
    }

    @After
    public void teardown() {
        System.out.println("teardown");
    }
}
