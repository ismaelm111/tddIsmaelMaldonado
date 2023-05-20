package ec.edu.epn.tdd.calculator;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;


import static org.junit.Assert.assertEquals;

public class ICalculatorTest {
    ICalculator c = null;

    @Before
    public void setUp() {
        c = Mockito.mock(ICalculator.class);
        System.out.println("setUp()");
    }

    @Test
    public void given_two_integers_when_addition_ok() {
        Mockito.when(c.addition(2, 3)).thenReturn(5);
        assertEquals(5, c.addition(2, 3));
        System.out.println("Test 1");
    }

    @Test
    public void given_two_integers_when_subtraction_then_ok() {
        Mockito.when(c.subtraction(4, 2)).thenReturn(2);
        assertEquals(2, c.subtraction(4, 2));
        System.out.println("Test 2");
    }

    @Test(expected = ArithmeticException.class)
    public void given_two_integers_when_division_then_exception() {
        Mockito.when(c.division(6, 0)).thenThrow(ArithmeticException.class);
        assertEquals(3, c.division(6, 0));
        System.out.println("Test 3");
    }

    @Test(timeout = 150)
    public void given_two_integers_when_multiplication_then_timeout() {
        Mockito.when(c.multiplication(4, 2)).thenAnswer((Answer<Integer>) invocationOnMock -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 8;
        });

       assertEquals(8, c.multiplication(4, 2));
        System.out.println("Test 4");
    }

}