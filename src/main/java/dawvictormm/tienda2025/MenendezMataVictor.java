/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dawvictormm.tienda2025;

/**
 *
 * @author alu16d
 */

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class MenendezMataVictor {
    
    Scanner sc=new Scanner(System.in);
    private ArrayList<Pedido> pedidos;
    private HashMap <String, Articulo> articulos;
    private HashMap <String, Cliente> clientes;
   
    public MenendezMataVictor() {
        pedidos = new ArrayList();
        articulos= new HashMap();
        clientes = new HashMap();
    }
  
  
    
    public static void main(String[] args) {
        MenendezMataVictor t=new MenendezMataVictor();
            
        t.cargaDatos();
        t.backupClientesConPedidos();
        t.leerClientesConPedidos();
        
        t.clientesConMasDe1000();
    }

    public void cargaDatos(){
       clientes.put("80580845T",new Cliente("80580845T","ANA ","658111111","ana@gmail.com"));
       clientes.put("36347775R",new Cliente("36347775R","ANTONIO","649222222","antonio@gmail.com"));
       clientes.put("63921307Y",new Cliente("63921307Y","AURORA","652333333","aurora@gmail.com"));
       clientes.put("53472775R",new Cliente("53472775R","EMILIO","649222222","emilio@gmail.com"));
       clientes.put("43211307Y",new Cliente("43211307Y","EVA","652333333","eva@gmail.com"));
       clientes.put("02337565Y",new Cliente("02337565Y","MATEO","634567890","mateo@gmail.com"));
       clientes.put("35445638M",new Cliente("35445638M","MARIA","633478990","maria@gmail.com"));
     
              
       articulos.put("1-11",new Articulo("1-11","RATON LOGITECH ST ",14,15));
       articulos.put("1-22",new Articulo("1-22","TECLADO STANDARD  ",9,18));
       articulos.put("2-11",new Articulo("2-11","HDD SEAGATE 1 TB  ",16,80));
       articulos.put("2-22",new Articulo("2-22","SSD KINGSTOM 256GB",9,70));
       articulos.put("2-33",new Articulo("2-33","SSD KINGSTOM 512GB",0,200));
       articulos.put("3-22",new Articulo("3-22","EPSON PRINT XP300 ",5,80));
       articulos.put("4-11",new Articulo("4-11","ASUS  MONITOR  22 ",5,100));
       articulos.put("4-22",new Articulo("4-22","HP MONITOR LED 28 ",5,180));
       articulos.put("4-33",new Articulo("4-33","SAMSUNG ODISSEY G5",12,580));
       
       LocalDate hoy = LocalDate.now();
       pedidos.add(new Pedido("80580845T-001/2024",clientes.get("80580845T"),hoy.minusDays(1), new ArrayList<>
        (List.of(new LineaPedido("1-11",3),new LineaPedido("4-22",3)))));                                                                                                                                                               
       pedidos.add(new Pedido("80580845T-002/2024",clientes.get("80580845T"),hoy.minusDays(2), new ArrayList<>
        (List.of(new LineaPedido("4-11",3),new LineaPedido("4-22",2),new LineaPedido("4-33",4)))));
       pedidos.add(new Pedido("36347775R-001/2024",clientes.get("36347775R"),hoy.minusDays(3), new ArrayList<>
        (List.of(new LineaPedido("4-22",1),new LineaPedido("2-22",3)))));
       pedidos.add(new Pedido("36347775R-002/2024",clientes.get("36347775R"),hoy.minusDays(5), new ArrayList<>
        (List.of(new LineaPedido("4-33",3),new LineaPedido("2-11",3)))));
       pedidos.add(new Pedido("63921307Y-001/2024",clientes.get("63921307Y"),hoy.minusDays(4), new ArrayList<>
        (List.of(new LineaPedido("2-11",5),new LineaPedido("2-33",3),new LineaPedido("4-33",2)))));
       pedidos.add(new Pedido("53472775R-001/2025",clientes.get("53472775R"),hoy, new ArrayList<>
        (List.of(new LineaPedido("1-11",2),new LineaPedido("2-11",2)))));
       pedidos.add(new Pedido("43211307Y-001/2025",clientes.get("43211307Y"),hoy, new ArrayList<>
        (List.of(new LineaPedido("4-33",1)))));

     } 
       
    
    
    public void backupClientesConPedidos() {
    try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("clientesCon.csv"))) {
        HashMap<String, Cliente> clientesConPedidos = new HashMap<>();
       
        for (Pedido p : pedidos) {
            clientesConPedidos.put(p.getClientePedido().getDni(), p.getClientePedido());
        }

        for (Cliente c : clientesConPedidos.values()) {
            oos.writeObject(c);
        }

        }catch (FileNotFoundException e) {
            System.out.println(e.toString());   
        }catch(IOException e){
            System.out.println(e.toString());
        }
}
    //sin acabar
    public void leerClientesConPedidos() {
         try (ObjectInputStream oisClientes = new ObjectInputStream(new FileInputStream ("clientesCon.csv"))){
       

            Cliente c;
            while ( (c=(Cliente)oisClientes.readObject()) !=null) {
                clientes.put(c.getDni(),c);
            } 
            
    } catch (FileNotFoundException e) {
        System.out.println(e.toString());
    } catch (EOFException e){
        
    } catch (ClassNotFoundException | IOException e){
        System.out.println(e.toString());
    }
     


    }  
  
    
    public void backupClientesSinPedidos() {
    try (BufferedWriter oos=new BufferedWriter(new FileWriter("clientesSin.csv"))) {
        ArrayList<Cliente> clientesSinPedidos = new ArrayList(clientes.values());
        
        for (Cliente c : clientesSinPedidos) {
                oos.write(c.getDni() + "," + c.getNombre() + "," + c.getTelefono() + "," + c.getEmail() + "\n");
            }

        System.out.println("Backup de clientes con pedidos realizado con éxito.");
    } catch (IOException e) {
        System.out.println("Error al guardar backup: " + e.getMessage());
    }
}


   
    
     public void clientesConMasDe1000() {
        try(BufferedWriter oosClientes = new BufferedWriter(new FileWriter ("clientesConMasDe1000.csv"))){
            ArrayList<Cliente> clientesConMasDe1000 = new ArrayList();

            for (Cliente c : clientes.values()) {
                double total =0;
                for (Pedido p : pedidos) {
                    if (p.getClientePedido().getDni().equals(c.getDni())) {
                        total+=totalPedido(p);
                    }
                }
                if (total > 1000) {
                    clientesConMasDe1000.add(c);
                    oosClientes.write(c.getDni() + "," + c.getNombre() + "," + c.getTelefono() + "," + c.getEmail() + "\n");
                }
            }  
            System.out.println("");
            System.out.println("Clientes con mas de 1000 pedidos");
            clientesConMasDe1000.forEach(System.out::println);
        }catch(IOException e){
            System.out.println(e.toString());
        }
    }  
     
   public double totalPedido(Pedido p) {
        double total=0;
        for (LineaPedido l:p.getCestaCompra())
        {
            total+=(articulos.get(l.getIdArticulo()).getPvp())
                    *l.getUnidades();
        }
        return total;
    }
    
}
