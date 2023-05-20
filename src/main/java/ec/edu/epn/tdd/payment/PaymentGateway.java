package ec.edu.epn.tdd.payment;

public interface PaymentGateway {
    PaymentResponse requestPayment(PaymentRequest paymentRequest);
}
