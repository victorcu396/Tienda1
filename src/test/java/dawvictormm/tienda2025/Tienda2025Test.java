
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package dawvictormm.tienda2025;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
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
public class Tienda2025Test {
    
    public Tienda2025Test() {
    }
    Tienda2025 t =new Tienda2025();
    LocalDate hoy= LocalDate.now();
    
    
    
    @BeforeEach
    public void antesDeCadaTest() {
        t.cargaDatos();
    }
    
    @Test
    public void testCargaDatos() {
        assertAll(
                () -> assertEquals (9, t.getArticulos().size()),
                () -> assertEquals (4, t.getClientes().size()),
                () -> assertEquals (5, t.getPedidos().size())
        );
    }
    
    
    /**
     * Test of totalPedido method, of class Tienda2025.
     
     *  @Test
    public void testTotalPedido() {
        assertAll(
            () -> assertEquals(585, t.totalPedido(t.getPedidos().get(0))),
            () -> assertEquals(2980, t.totalPedido(t.getPedidos().get(1))),
            () -> assertEquals(390, t.totalPedido(t.getPedidos().get(2))),
            () -> assertEquals(1980, t.totalPedido(t.getPedidos().get(3))),
            () -> assertEquals(2160, t.totalPedido(t.getPedidos().get(4)))
        );
    }
    */
    @Test
    public void testTotalPedido() {
        System.out.println("getPedidos");
          
        Pedido p1 =new Pedido("80580845T-001/2024",t.getClientes().get("80580845T"),hoy.minusDays(1), new ArrayList<>
        (List.of(new LineaPedido("1-11",3),new LineaPedido("4-22",3))));          
        
       Pedido p2 =new Pedido("80580845T-002/2024",t.getClientes().get("80580845T"),hoy.minusDays(2), new ArrayList<>
        (List.of(new LineaPedido("4-11",3),new LineaPedido("4-22",2),new LineaPedido("4-33",4))));
       
       Pedido p3 =new Pedido("36347775R-001/2024",t.getClientes().get("36347775R"),hoy.minusDays(3), new ArrayList<>
        (List.of(new LineaPedido("4-22",1),new LineaPedido("2-22",3))));
       
       Pedido p4 =new Pedido("36347775R-002/2024",t.getClientes().get("36347775R"),hoy.minusDays(5), new ArrayList<>
        (List.of(new LineaPedido("4-33",3),new LineaPedido("2-11",3))));
       
       Pedido p5 =new Pedido("63921307Y-001/2024",t.getClientes().get("63921307Y"),hoy.minusDays(4), new ArrayList<>
        (List.of(new LineaPedido("2-11",5),new LineaPedido("2-33",3),new LineaPedido("4-33",2))));
       
       
     assertEquals(585, t.totalPedido(p1));
     assertEquals(2980, t.totalPedido(p2));
     assertEquals(390, t.totalPedido(p3));
     assertEquals(1980, t.totalPedido(p4));
     assertEquals(2160, t.totalPedido(p5));
 
    }

    /**
     * Test of stock method, of class Tienda2025.
     
    @Test
    public void testStock() throws Exception {
        assertAll(
                () -> assertThrows(StockInsuficiente.class, ()-> {t.stock("1-11",22);}, "El stock es induficiente"),
                () -> assertThrows(StockAgotado.class, ()-> {t.stock("2-33",5);}, "El stock esta agotado")
        );
    }
*/
    @Test
    public void testStock() {
        assertAll(  
            () -> assertThrows(StockInsuficiente.class,()-> {t.stock("1-11",22);},"El Stock es insuficiente"),
            () -> assertThrows(StockAgotado.class, ()-> {t.stock("2-33",5);}, "El Stock esta agotado")
        );
    }
    
    /**
     * Test of totalCliente method, of class Tienda2025.
     *@Test
    public void testTotalCliente() {
        assertAll(
            () -> assertEquals(3565, t.totalCliente(t.getClientes().get("80580845T"))),
            () -> assertEquals(2370, t.totalCliente(t.getClientes().get("36347775R"))),
            () -> assertEquals(2160, t.totalCliente(t.getClientes().get("63921307Y"))),
            () -> assertEquals(580, t.totalCliente(t.getClientes().get("43211307Y"))),
            () -> assertEquals(190, t.totalCliente(t.getClientes().get("53472775R")))
        );
    }
    */
    @Test
    public void testTotalCliente() {
        Cliente cliente1 = t.getClientes().get("80580845T"); // Replace with actual key for ANA
        Cliente cliente2 = t.getClientes().get("36347775R"); // Replace with actual key for LOLA
        Cliente cliente3 = t.getClientes().get("63921307Y"); // Replace with actual key for JUAN
        Cliente cliente4 = t.getClientes().get("00000000X"); // Replace with actual key for EDU (or a valid key)

        assertAll(
                () -> assertEquals(3565.0, t.totalCliente(cliente1), "Total incorrecto para cliente ANA"),
                () -> assertEquals(2370.0, t.totalCliente(cliente2), "Total incorrecto para cliente LOLA"),
                () -> assertEquals(2160.0, t.totalCliente(cliente3), "Total incorrecto para cliente JUAN"),
                () -> assertEquals(0.0, t.totalCliente(cliente4), "Total incorrecto para cliente EDU")
        );
    }

    /**
     * Test of totalCliente2 method, of class Tienda2025.
     */
    @Test
    public void testTotalCliente2() {
       assertAll(
            () -> assertEquals(3565, t.totalCliente2(t.getClientes().get("80580845T"))),
            () -> assertEquals(2370, t.totalCliente2(t.getClientes().get("36347775R"))),
            () -> assertEquals(2160, t.totalCliente2(t.getClientes().get("63921307Y"))),
            () -> assertEquals(580, t.totalCliente2(t.getClientes().get("43211307Y"))),
            () -> assertEquals(190, t.totalCliente2(t.getClientes().get("53472775R")))
        );
    }

  
    
       //EXAMEN ENDES  
    
    //2.1
    @Test
     public void testCargaDatosAdditional() {
        assertAll(
                () -> assertEquals (8, t.getArticulos().size()),
                () -> assertEquals (5, t.getClientes().size()),
                () -> assertEquals (5, t.getPedidos().size())
        );
    }
    
     
    //2.2
    @Test
    public void testTotalPedidoAdditional() {
        assertAll(
            () -> assertEquals(1500, t.totalPedido(t.getPedidos().get(0)), "El pedido con mayor importe"),
            () -> assertEquals(285, t.totalPedido(t.getPedidos().get(3)), "El pedido con menor importe"),
            () -> assertEquals(500, t.totalPedido(t.getPedidos().get(1)),"Un pedido cualquiera")
            );
    }

    //2.3
    @Test
    public void testTotalClienteAdditional() {
        assertAll(
            () -> assertEquals(2000, t.totalCliente(t.getClientes().get("90015161S")),"El cliente con mayor importe gastado"),
            () -> assertEquals(285, t.totalCliente(t.getClientes().get("95767515T")), "El cliente con menor importe gastado"),
            () -> assertEquals(390, t.totalCliente(t.getClientes().get("96819473F")),"Otro pedido cualquiera")
            );
    }

    
    //2.4
    @Test
    public void testStockAdditional() {
        assertAll(  
            () -> assertThrows(StockInsuficiente.class,()-> {t.stock("4-22",22);},"El Stock es insuficiente"),
            () -> assertThrows(StockAgotado.class, ()-> {t.stock("2-22",5);}, "El Stock esta agotado")
        );
    }
     
    
    
    
}
