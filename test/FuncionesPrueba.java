import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class FuncionesPrueba {

    Funciones funciones = new Funciones();

    @Test
    @DisplayName("Prueba método sumar()")
    void pruebaSuma(){
        //(valorEsperado, llamarFunción)
        assertEquals(0, funciones.sumar(0,0));
        assertEquals(2, funciones.sumar(1,1));
        assertEquals(4, funciones.sumar(2,2));
        assertEquals(-2, funciones.sumar(3,-5));

    }// pruebaSuma

    @Test
    @DisplayName("Prueba método validadCorreo()")
    void pruebaValidarCorreo(){
        assertTrue(funciones.validarCorreo("fernando@hotmail.com.mx"));
        assertFalse(funciones.validarCorreo("correodominio.com.mx"));
        assertTrue(funciones.validarCorreo("correo@hotmail.com.mx"));
        assertFalse(funciones.validarCorreo("correodominio"));
    }//pruebaValidarCorreo
}//class FuncionesPrueba
