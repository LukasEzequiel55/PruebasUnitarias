import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PurchaseCalculatorTest {
    PurchaseCalculator calculadora = new PurchaseCalculator();

    @Test
    @DisplayName("Prueba calculo de subtotal")
    void pruebacalculosubtotal(){
        //(valorEsperado, llamarFunción)
        assertEquals(300, calculadora.calculateSubtotal(100,3));
        assertEquals(1, calculadora.calculateSubtotal(1,1));
        assertEquals(0, calculadora.calculateSubtotal(0,3));
    }//pruebacalculosubtotal

    @Test
    @DisplayName("Prueba validación de compra")
    void pruebavalidacioncompra(){
        //(valorEsperado, llamarFunción)
        assertTrue(calculadora.isValidPurchase(100,5));
        assertFalse(calculadora.isValidPurchase(0,10));
        assertFalse(calculadora.isValidPurchase(100,0));
        assertFalse(calculadora.isValidPurchase(-100,10));
    }//pruebavalidacioncompra

    @Test
    @DisplayName("Prueba calculo de descuento")
    void pruebadescuento(){
        //(valorEsperado, llamarFunción)
        assertEquals(0.0,calculadora.calculateDiscount(999.0), 0.001);
        assertEquals(100.0,calculadora.calculateDiscount(1000.0));
        assertEquals(160.0,calculadora.calculateDiscount(1600.0), 0.001);
    }//pruebadescuento

    @Test
    @DisplayName("Prueba precio final")
    void preciofinal(){
        //(valorEsperado, llamarFunción)
        assertEquals(900,calculadora.calculateFinalPrice(900));
        assertEquals(1350,calculadora.calculateFinalPrice(1500));
        assertEquals(900,calculadora.calculateFinalPrice(1000));
    }
}//PurchaseCalculator
