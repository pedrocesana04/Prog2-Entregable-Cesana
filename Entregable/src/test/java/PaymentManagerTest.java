import org.ejercicio.Logica.PaymentManager;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentManagerTest {
    private PaymentManager paymentManager;

    @BeforeEach
    void setUp(){
        paymentManager = new PaymentManager();
    }

    @AfterEach
    void tearDown(){

    }

    @Test
    void proveedorPaypalSuccessfully(){
        String paypal1 = paymentManager.processPayment(2000, "paypal");
        String paypal2 = paymentManager.processPayment(5000, "paypal");

        Assertions.assertEquals(paypal1,"Paypal captura: $2000.0 Paypal autoriza: $2000.0");
        Assertions.assertEquals(paypal2,"Paypal captura: $5000.0 Paypal autoriza: $5000.0");
    }

    @Test
    void proveedorMercadopagoSuccessfully(){
        String mercadopago1 = paymentManager.processPayment(2000, "mercadopago");
        String mercadopago2 = paymentManager.processPayment(5000, "mercadopago");

        Assertions.assertEquals(mercadopago1,"Mercado Pago captura: $2000.0 Mercado Pago autoriza: $2000.0");
        Assertions.assertEquals(mercadopago2,"Mercado Pago captura: $5000.0 Mercado Pago autoriza: $5000.0");
    }

    @Test
    void proveedorDesconocido(){
        String desconocido = paymentManager.processPayment(2000, "Banco Provincia");

        Assertions.assertEquals(desconocido, "El proveedor no está registrado.");
    }
}
