package ec.edu.epn.tdd.payment;

import ec.edu.epn.tdd.calculator.ICalculator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProcessorTest {
    PaymentGateway gateway = null;
    PaymentProcessor processor = null;

    @Before
    public void setUp() {
        gateway = Mockito.mock(PaymentGateway.class);
        processor = new PaymentProcessor(gateway);
        System.out.println("setUp()");
    }

    @Test
    public void given_payment_when_is_correct_then_ok() {
        Mockito.when(gateway.requestPayment(Mockito.any())).thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));
        assertTrue(processor.makePayment(100));
        System.out.println("payment ok");
    }

    @Test
    public void given_payment_when_is_wrong_then_error() {
        Mockito.when(gateway.requestPayment(Mockito.any())).thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));
        assertFalse(processor.makePayment(100));
        System.out.println("payment error");
    }
}