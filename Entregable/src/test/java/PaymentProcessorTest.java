import org.ejercicio.Logica.*;
import org.junit.jupiter.api.*;

public class PaymentProcessorTest {
    private PaymentProcessor paymentProcessor;
    private PaymentGateway paymentGateway;

    @BeforeEach
    void setUp(){

    }

    @AfterEach
    void tearDown(){

    }

    @Test
    void reembolsoPaypal(){
        paymentGateway = new PaypalGateway();
        paymentProcessor = new PaypalPaymentProcessor(paymentGateway);

        String paypal1 = paymentProcessor.refundPayment(2000);
        String paypal2 = paymentProcessor.refundPayment(5000);

        Assertions.assertEquals(paypal1,"Paypal reembolsa: $2000.0");
        Assertions.assertEquals(paypal2,"Paypal reembolsa: $5000.0");
    }

    @Test
    void reembolsoMercadopago(){
        paymentGateway = new MercadoPagoGateWay();
        paymentProcessor = new MercadoPagoPaymentProcessor(paymentGateway);

        String mercadopago1 = paymentProcessor.refundPayment(2000);
        String mercadopago2 = paymentProcessor.refundPayment(5000);

        Assertions.assertEquals(mercadopago1,"Mercado Pago reembolsa: $2000.0");
        Assertions.assertEquals(mercadopago2,"Mercado Pago reembolsa: $5000.0");
    }
}
