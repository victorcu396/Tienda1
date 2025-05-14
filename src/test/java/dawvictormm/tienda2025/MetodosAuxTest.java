/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dawvictormm.tienda2025;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alu16d
 */
public class MetodosAuxTest {
    
    public MetodosAuxTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of esInt method, of class MetodosAux.
     */
    @Test
    public void testEsInt() {
        System.out.println("Test para el metodo esInt");
        assertTrue(MetodosAux.esInt("-5"), "El -5 es int");
        assertTrue(MetodosAux.esInt("5"), "El 5 es int");
        assertFalse(MetodosAux.esInt("5.5"), "El 5.5 no es int");
        assertFalse(MetodosAux.esInt("xty"), "xty no es int");
    }

    /**
     * Test of esDouble method, of class MetodosAux.
     */
    @Test
    public void testEsDouble() {
        System.out.println("Test para el metodo esDouble");
        assertTrue(MetodosAux.esDouble("-5"), "El -5 no es double");
        assertTrue(MetodosAux.esDouble("5"), "El 5 no es double");
        assertTrue(MetodosAux.esDouble("5.5"), "El 5.5 es double");
        assertFalse(MetodosAux.esDouble("xty"), "xty no es double");
        
    }

    /* SIN assertAll Junit nos indicará ERROR en el test, pero sin mostrar 
        indormación detallada de que asserts han fallado
        
      assertTrue(MetodosAux.esInt("5"),"El 5 es int");
      assertTrue(MetodosAux.esInt("-5"),"El -5 es int");
      assertFalse(MetodosAux.esInt("5.5"),"5.5 NO es int");
      assertFalse(MetodosAux.esInt("dxsfgsdrfg"),"dxsfgsdrfg NO es int");
       
      LOS METODOS QUE DEVUELVEN UN VALOR BOOLEAN TAMBIÉN SE PUEDE PROBAR CON assertEquals 
      
      assertEquals(true, MetodosAux.esInt("5"),"El 5 es int");
      assertEquals(true, MetodosAux.esInt("-5"),"El -5 es int");
      assertEquals(false, MetodosAux.esInt("5.5"),"5.5 NO es int");
      assertEquals(false, MetodosAux.esInt("dxsfgsdrfg"),"dxsfgsdrfg NO es int");
      */
    
    
    /**
     * Test of validarDNI method, of class MetodosAux.
     */
    @Test
    public void testValidarDNI() {
        System.out.println("Test para el metodo validarDNI");
        assertTrue(MetodosAux.validarDNI("80580845T"), "El DNI 80580845T es valido");
        assertTrue(MetodosAux.validarDNI("36347775R"), "El DNI 36347775R es valido");
        assertFalse(MetodosAux.validarDNI("36347775X"), "El DNI 36347775X no es valido");
        assertFalse(MetodosAux.validarDNI("36347775"), "El DNI 36347775 no es valido");
    }
    

    
   //EXAMEN ENDES  
    


    //1.1
    @Test
    public void testEsIntAdditional() {
        System.out.println("Additional tests for esInt method");
        assertAll(
            () -> assertTrue(MetodosAux.esInt("8"), "El 8 es int"),
            () -> assertTrue(MetodosAux.esInt("46"), "El 46 es int"),
            () -> assertTrue(MetodosAux.esInt("55"), "El 55 es int"),
            () -> assertFalse(MetodosAux.esInt("8.8"), "El 8.8 NO es int"),
            () -> assertFalse(MetodosAux.esInt("-55.5"), "El -55.5 NO es int"),
            () -> assertFalse(MetodosAux.esInt("HOLA"), "HOLA NO es int")
        );
    }
    //1.2
    @Test
    public void testEsDoubleAdditional() {
        System.out.println("Additional tests for esDouble method");
        assertAll(
            () -> assertTrue(MetodosAux.esDouble("8"), "El 8 NO es double"),
            () -> assertTrue(MetodosAux.esDouble("55"), "El 55 NO es double"),
            () -> assertTrue(MetodosAux.esDouble("8.8"), "El 8.8 es double"),
            () -> assertTrue(MetodosAux.esDouble("-55.5"), "El -55.5 es double"),
            () -> assertFalse(MetodosAux.esDouble("HOLA"), "HOLA NO es double"),
            () -> assertFalse(MetodosAux.esDouble("E"), "E NO es double")
        );
    }
    //1.3
    @Test
    public void testValidarDNIAdditional() {
        System.out.println("Additional tests for validarDNI method");
        assertAll(
            () -> assertTrue(MetodosAux.validarDNI("90015161S"), "El DNI 90015161S es válido"),
            () -> assertTrue(MetodosAux.validarDNI("90463229C"), "El DNI 90463229C es válido"),
            () -> assertFalse(MetodosAux.validarDNI("72825528R"), "El DNI 72825528R NO es válido"),
            () -> assertFalse(MetodosAux.validarDNI("90463229X"), "El DNI 90463229X NO es válido")
        );
    }

    
}
