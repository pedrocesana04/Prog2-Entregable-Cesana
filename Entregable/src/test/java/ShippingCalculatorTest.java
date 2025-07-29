import org.ejercicio.Logica.*;
import org.junit.jupiter.api.*;

public class ShippingCalculatorTest {
    private ShippingCalculator shippingCalculator1;
    private ShippingCalculator shippingCalculator2;

    @BeforeEach
    void setUp(){
        shippingCalculator1 = new ShippingCalculator(10.0, 20, "Rio de Janeiro", "Buenos Aires");
        shippingCalculator2 = new ShippingCalculator(20.0, 40, "Rio de Janeiro", "Buenos Aires");
    }

    @AfterEach
    void tearDown(){

    }

    @Test
    void envioAereo(){
        shippingCalculator1.setShippingStrategy(new AirShippingStrategy());
        shippingCalculator2.setShippingStrategy(new AirShippingStrategy());

        double precio1 = shippingCalculator1.calculateCost();
        double precio2 = shippingCalculator2.calculateCost();

        Assertions.assertEquals(precio1, 51);
        Assertions.assertEquals(precio2, 72);
    }

    @Test
    void envioTerrestre(){
        shippingCalculator1.setShippingStrategy(new TruckShippingStrategy());
        shippingCalculator2.setShippingStrategy(new TruckShippingStrategy());

        double precio1 = shippingCalculator1.calculateCost();
        double precio2 = shippingCalculator2.calculateCost();

        Assertions.assertEquals(precio1, 52);
        Assertions.assertEquals(precio2, 84);
    }

    @Test
    void envioMaritimo(){
        shippingCalculator1.setShippingStrategy(new BoatShippingStrategy());
        shippingCalculator2.setShippingStrategy(new BoatShippingStrategy());

        double precio1 = shippingCalculator1.calculateCost();
        double precio2 = shippingCalculator2.calculateCost();

        Assertions.assertEquals(precio1, 30);
        Assertions.assertEquals(precio2, 50);
    }

    @Test
    void asignarTodosLosValores(){
        ShippingCalculator shippingCalculator = new ShippingCalculator(10, 20, "Rio de Janeiro", "Buenos Aires", new AirShippingStrategy());

        Assertions.assertEquals(shippingCalculator.getShippingStrategy().getClass(), AirShippingStrategy.class);
        Assertions.assertEquals(shippingCalculator.getDestino(), "Buenos Aires");
        Assertions.assertEquals(shippingCalculator.getOrigen(), "Rio de Janeiro");
        Assertions.assertEquals(shippingCalculator.getPeso(), 10);
        Assertions.assertEquals(shippingCalculator.getVolumen(), 20);
    }

    @Test
    void noAsignarValores(){
        ShippingCalculator shippingCalculator = new ShippingCalculator();

        Assertions.assertEquals(shippingCalculator.getVolumen(), 0);
        Assertions.assertEquals(shippingCalculator.getPeso(), 0.0);
        Assertions.assertEquals(shippingCalculator.getOrigen(), null);
        Assertions.assertEquals(shippingCalculator.getDestino(), null);
        Assertions.assertEquals(shippingCalculator.getShippingStrategy(), null);
    }
}
