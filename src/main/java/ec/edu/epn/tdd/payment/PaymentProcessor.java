package ec.edu.epn.tdd.payment;

public class PaymentProcessor {
    private  PaymentGateway gateway;

    public PaymentProcessor(PaymentGateway gateway) {
        this.gateway = gateway;
    }
    public boolean makePayment(double amount){
        PaymentResponse response = gateway.requestPayment((new PaymentRequest(amount)));
        return response.getStatus() == PaymentResponse.PaymentStatus.OK;
    }
}
