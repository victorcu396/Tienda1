/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package dawvictormm.tienda2025;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author alu16d
 */
public class Tienda2025 {

    public Tienda2025() {
        pedidos = new ArrayList<>();
        articulos = new HashMap<>();
        clientes = new HashMap<>();
    }
    
    Scanner sc=new Scanner(System.in);
    private ArrayList<Pedido> pedidos;
    private HashMap <String, Articulo> articulos;
    private HashMap <String, Cliente> clientes;
    
     public static void main(String[] args) {
       Tienda2025 t=new Tienda2025();
       t.leerArchivos();
  //     t.cargaDatos();
       t.mostrarMenuPrincipal();
       t.backup();
       
     }
    //<editor-fold defaultstate="collapsed" desc="CARGA  DATOS">
    /**
 public void cargaDatos(){
        
       clientes.put("80580845T",new Cliente("80580845T","ANA","658111111","ana@gmail.com"));
       clientes.put("36347775R",new Cliente("36347775R","LOLA","649222222","lola@gmail.com"));
       clientes.put("63921307Y",new Cliente("63921307Y","JUAN","652333333","juan@gmail.com"));
       clientes.put("02337565Y",new Cliente("02337565Y","EDU","634567890","edu@gmail.com"));
              
       articulos.put("1-11",new Articulo("1-11","RATON LOGITECH ST ",14,15));
       articulos.put("1-22",new Articulo("1-22","TECLADO STANDARD  ",9,18));
       articulos.put("2-11",new Articulo("2-11","HDD SEAGATE 1 TB  ",16,80));
       articulos.put("2-22",new Articulo("2-22","SSD KINGSTOM 256GB",9,70));
       articulos.put("2-33",new Articulo("2-33","SSD KINGSTOM 512GB",0,200));
       articulos.put("3-22",new Articulo("3-22","EPSON PRINT XP300 ",5,80));
       articulos.put("4-11",new Articulo("4-11","ASUS  MONITOR  22 ",5,100));
       articulos.put("4-22",new Articulo("4-22","HP MONITOR LED 28 ",5,180));
       articulos.put("4-33",new Articulo("4-33","SAMSUNG ODISSEY G5",2,580));
       
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
    
 
     for (Pedido pedido : pedidos) {
         System.out.println(pedido);
     }
    
        System.out.println("");
        
        System.out.println(clientes);
       
        System.out.println("");
        
        System.out.println(articulos);
        
        System.out.println("");
 }
    */
//</editor-fold>     
  
    
 
 //<editor-fold defaultstate="collapsed" desc="MENÚ  PRINCIPAL">
     private void mostrarMenuPrincipal() {
        Scanner sc = new Scanner(System.in);
        int opcion=0;
        do {
            System.out.println("\n  \t\t-----GESTION DE MENUS-----  \n");
            System.out.println("\t\t1. GESTIÓN DE PEDIDOS");
            System.out.println("\t\t2. GESTIÓN DE ARTÍCULOS");
            System.out.println("\t\t3. GESTIÓN DE CLIENTES");
            System.out.println("\t\t4. Copia de Seguridad");
            System.out.println("\t\t5. Leer Archivos");
            System.out.println("\t\t0. Volver");
            System.out.print("\t\tSeleccione una opción: ");

            opcion=sc.nextInt(); 
            switch (opcion) { 
                case 1:{
                    MenuPedidos();
                    break;
                }
                case 2:{
                    MenuArticulos();
                    break;
                }
                case 3:{
                    MenuClientes();
                    break;
                }
                case 4:{
                    backup();
                    break;
                }
                case 5:{
                    leerArchivos();
                    break;
                }
                case 0:{
                    System.out.println("\t\tSALIENDO DE LA TIENDA...");
                    break;
                }
            }
        }while(opcion !=0);
    }
//</editor-fold>
    
  
    //<editor-fold defaultstate="collapsed" desc="GESTIÓN  DE  PEDIDOS">
     private void MenuPedidos() {
        Scanner sc = new Scanner(System.in);
        int opcion=0;
        do {
            System.out.println("\n  \t\t-----GESTION DE PEDIDOS-----  \n");
            System.out.println("\t\t1. Crear Pedido");
            System.out.println("\t\t2. Listar Pedidos");
            System.out.println("\t\t3. Listar Pedidos Por Total Del Precio");
            System.out.println("\t\t0. Volver");
            System.out.print("\t\tSeleccione una opción: ");

            opcion=sc.nextInt(); 
            switch (opcion) { 
                case 1:{
                    nuevoPedido();
                    break;
                }
                case 2:{
                    listarPedidos();
                    break;
                }
                case 3:{
                    listarPedidosPorTotal();
                    break;
                }
                case 0:{
                    System.out.println("\t\tVolviendo al menú principal...");
                    break;
                }
            }
        }while(opcion !=0);
    }
    
     public void stock(String id, int unidadesPed) throws StockAgotado, StockInsuficiente{
        int n=articulos.get(id).getExistencias();
        if (n==0) {
            throw new StockAgotado ("Stock AGOTADO para el artículo: " + articulos.get(id).getDescripcion());
        }else if (n< unidadesPed){
            throw new StockInsuficiente ("Stock AGOTADO para el artículo: " + unidadesPed + "de " + articulos.get(id).getDescripcion() + "y sólo se dispone de: " + n);
        }
        
    }
    
     public String generaIdPedido (String idCliente){
         int contador=0;
         String nuevoId;
         for (Pedido p : pedidos) {
             if (p.getClientePedido().getDni().equalsIgnoreCase(idCliente)) {
                 contador++;
             }
         }
         contador++;
         nuevoId= idCliente+"-" + String.format("%03d", contador) + "/" + LocalDate.now().getYear();
         return nuevoId;
     }
    
     public void nuevoPedido() {
        //ARRAYLIST AUXILIAR PARA CREAR EL PEDIDO
        ArrayList<LineaPedido> CestaCompraAux = new ArrayList();
        String dniT, idT, opc, pedidasS;
        int pedidas=0;
        sc.nextLine();
        do{
            System.out.println("CLIENTE PEDIDO (DNI):");
            dniT=sc.nextLine().toUpperCase();
            //EN CUALQUIER MOMENTO PODEMOS SALIR DEL BUCLE TECLEANDO RETORNO
            if (dniT.isBlank()) break;
            if (!MetodosAux.validarDNI(dniT)|| !clientes.containsKey(dniT)) System.out.println("El DNI no es válido O NO ES CLIENTE DE LA TIENDA");;
        }while (!clientes.containsKey(dniT));
        
        if (!dniT.isBlank()){
            System.out.println("\t\tCOMENZAMOS CON EL PEDIDO");
            System.out.println("INTRODUCE CODIGO ARTICULO (RETURN PARA TERMINAR): ");
            idT=sc.nextLine();
                 
            while (!idT.isEmpty()) {
                if (!articulos.containsKey(idT)){
                    System.out.println("El ID articulo tecleado no existe");
                }else{
                    System.out.print("(" + articulos.get(idT).getDescripcion()+ ") - UNIDADES? ");
                    do {
                        pedidasS=sc.nextLine();
                    }while(!MetodosAux.esInt(pedidasS)); 

                    pedidas=Integer.parseInt(pedidasS);

                    try{
                        stock(idT,pedidas); // LLAMO AL METODO STOCK, PUEDEN SALTAR 2 EXCEPCIONES
                        CestaCompraAux.add(new LineaPedido(idT,pedidas));
                        articulos.get(idT).setExistencias(articulos.get(idT).getExistencias()-pedidas);
                    }catch (StockAgotado e){
                        System.out.println(e.getMessage());
                    }catch (StockInsuficiente e){
                        System.out.println(e.getMessage());
                        int disponibles=articulos.get(idT).getExistencias();
                        System.out.print("QUIERES LAS " + disponibles + " UNIDADES DISPONIBLES? (S/N) ");
                        opc=sc.next();
                        if (opc.equalsIgnoreCase("S")){
                            CestaCompraAux.add(new LineaPedido(idT,disponibles));
                            articulos.get(idT).setExistencias(articulos.get(idT).getExistencias()-disponibles);
                        }
                    }
                }
                System.out.println("INTRODUCE CODIGO ARTICULO (RETURN PARA TERMINAR): ");
                idT=sc.nextLine();
            }
         
            //IMPRIMO EL PEDIDO Y SOLICITO ACEPTACION DEFINITIVA DEL MISMO 
            for (LineaPedido l:CestaCompraAux)
            {
                System.out.println(articulos.get(l.getIdArticulo()).getDescripcion() + " - ("+ l.getUnidades() + ")");
            }
            System.out.println("ESTE ES TU PEDIDO. PROCEDEMOS? (S/N)   ");
            opc=sc.next();
            if (opc.equalsIgnoreCase("S")){
            // ESCRIBO EL PEDIDO DEFINITIVAMENTE Y DESCUENTO LAS EXISTENCIAS PEDIDAS DE CADA ARTICULO
                LocalDate hoy=LocalDate.now();
                pedidos.add(new Pedido(generaIdPedido(dniT),clientes.get(dniT),hoy,CestaCompraAux));
            }
            else{    
                for (LineaPedido l:CestaCompraAux)
                {
                    articulos.get(l.getIdArticulo()).setExistencias(articulos.get(l.getIdArticulo()).getExistencias()+l.getUnidades());
                } 
            }
        }
    }
     

    private void listarPedidos() {
         
        Collections.sort(pedidos);
        System.out.println("");
        System.out.println("----- PEDIDOS ORDENADOS POR FECHA DE PEDIDOS ------");
        for (Pedido p : pedidos) {
            System.out.println(p);
        }
        System.out.println("");
        System.out.println("----- PEDIDOS ORDENADOS AL REVES -----");
        Collections.reverse(pedidos);
        for (Pedido p : pedidos) {
            System.out.println(p);
        }
    }

   
    public void listarPedidosPorTotal() {
         Scanner sc= new Scanner(System.in);
        
        System.out.println(totalPedido(pedidos.get(0)));
        
        pedidos.stream().sorted(Comparator.comparing(p -> totalPedido(p)))
                .forEach(p -> System.out.println(p + "\t\t - IMPORTE TOTAL:" + totalPedido(p)));
              
        System.out.println("\n");
        System.out.println("De que cliente queire ver el pedido?\nPor favor, ingrese el nombre: ");
        String nombre=sc.nextLine().toUpperCase();
        
        pedidos.stream().filter(p -> p.getClientePedido().getNombre().equals(nombre))
                .filter(p -> totalPedido(p)>500)
                .sorted(Comparator.comparing(p -> totalPedido(p)))
                .forEach(p -> System.out.println(p + "\t\t - IMPORTE TOTAL:" + totalPedido(p)));
        
        System.out.println("Teclea Sección: ");
        char s=sc.next().charAt(0);
        articulos.values().stream().filter(a -> a.getIdArticulo().charAt(0)==s)
                .sorted(new ComparaArticulosPorPrecio().reversed()).forEach(System.out::println);
        
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
    
    
     
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GESTIÓN  DE  ARTÍCULOS">
    private void MenuArticulos() {
        Scanner sc = new Scanner(System.in);
        int opcion=0;
        do {
            System.out.println("\n  \t\t-----GESTION DE ARTICULOS-----  \n");
            System.out.println("\t\t1. Crear Artículo");
            System.out.println("\t\t2. Eliminar Artículo");
            System.out.println("\t\t3. Listar Artículos");
            System.out.println("\t\t4. Ordenar Artículos con Streams");
            System.out.println("\t\t5. Crear un archivo por Seccion");
            System.out.println("\t\t6. Listar Artticulos segun la Seccion (desde archivos)");
            System.out.println("\t\t0. Volver");
            System.out.print("\t\tSeleccione una opción: ");

            opcion=sc.nextInt(); 
            switch (opcion) { 
                case 1:{
                    nuevoArticulo();
                    break;
                }
                case 2:{
                    eliminarArticulo();
                    break;
                }
                case 3:{
                    listarArticulos();
                    break;
                }
                 case 4:{
                    OrdenarArticulos();
                    break;
                }
                 case 5:{
                    backupPorSeccion();
                    break;
                }
                case 6:{
                    leerArchivosSeccion();
                    break;
                }
                case 0:{
                    System.out.println("\t\tVolviendo al menú principal...");
                    break;
                }
            }
        }while(opcion !=0);
    }
    
    private void nuevoArticulo() {
        String id, descripcion;
    int existencias;
    double precio;

    do {
        System.out.print("Ingrese el ID del artículo: ");
        id = sc.nextLine();
        if (articulos.containsKey(id)) {
            System.out.println("El ID ya existe. Intente con otro.");
            return;
        }
    } while (id.isEmpty());

    System.out.print("Ingrese la descripción del artículo: ");
    descripcion = sc.nextLine();

    do {
        System.out.print("Ingrese la cantidad en stock: ");
        while (!sc.hasNextInt()) {
            System.out.println("Por favor, introduzca un número válido.");
            sc.next();
        }
        existencias = sc.nextInt();
    } while (existencias < 0);

    do {
        System.out.print("Ingrese el precio: ");
        while (!sc.hasNextDouble()) {
            System.out.println("Por favor, introduzca un precio válido.");
            sc.next();
        }
        precio = sc.nextDouble();
    } while (precio <= 0);

    Articulo a = new Articulo(id, descripcion, existencias, precio);
    articulos.put(id, a);
    System.out.println("Artículo añadido correctamente.");
    }
     
     private void eliminarArticulo(){
        System.out.println("Hola");
    }
    
    private void listarArticulos() {
        
        ArrayList<Articulo> articulosAux = new ArrayList(articulos.values());
        System.out.println("");
        System.out.println("----- LISTADO DE ARTICULOS POR EXISTENCIAS -----");
        Collections.sort(articulosAux, new ComparaArticulosPorExistencias());
        for (Articulo a : articulosAux) {
            System.out.println(a);
        }
        
        /**
         * Collections.sort(articulos, new ComparaArticulosPorExistencias());
           artículosAux.forEach(System.out::println); 
           Collections.reverse(artículos);
           artículosAux.forEach(System.out::println);
         */
        
        System.out.println("");
        System.out.println("----- AL REVES -----");
        
        Collections.reverse(articulosAux);
        for (Articulo a : articulosAux) {
            System.out.println(a);
        }
    }
    
    private void OrdenarArticulos(){
        System.out.println("");
        System.out.println("----- ARTÍCULOS DESORDENADOS -----");
        articulos.values().stream().sorted().forEach(System.out::println);
        System.out.println("");
        System.out.println("----- ARTÍCULOS ORDENADOS POR EXISTENCIAS -----");
        articulos.values().stream().sorted(new ComparaArticulosPorExistencias()).forEach(System.out::println);
        System.out.println("");
        System.out.println("----- ARTÍCULOS ORDENADOS POR PRECIO -----");
        articulos.values().stream().sorted(new ComparaArticulosPorPrecio()).forEach(System.out::println);
        
    }

     
    public void leerArchivosSeccion() {
        System.out.println("Teclea la Seccion de los articulos que quieres recuperar:");        
        String id=sc.next();
        ArrayList<Articulo> articulosAux= new ArrayList();
        Articulo a;
        
        try (ObjectInputStream oisArticulos = new ObjectInputStream(new FileInputStream("articulos.dat"))){
            while ( (a=(Articulo)oisArticulos.readObject()) != null){
                if (id.equals("5")){
                    articulosAux.add(a);
                }else if (a.getIdArticulo().startsWith(id)){
                    articulosAux.add(a);
                }
            } 
        } catch (FileNotFoundException e) {
                 System.out.println(e.toString());    
        } catch (EOFException e){
            
        } catch (ClassNotFoundException | IOException e) {
                System.out.println(e.toString()); 
        } 
        
        articulosAux.forEach(System.out::println);
    }
    
    public void backupPorSeccion() {
        try (ObjectOutputStream oosPerifericos = new ObjectOutputStream(new FileOutputStream("Perifericos.dat"));
            ObjectOutputStream oosAlmacenamiento = new ObjectOutputStream(new FileOutputStream("Almacenamiento.dat"));
            ObjectOutputStream oosImpresoras = new ObjectOutputStream(new FileOutputStream("Impresoras.dat"));
            ObjectOutputStream oosMonitores = new ObjectOutputStream (new FileOutputStream("Monitores.dat"))) {
	   	   
            for (Articulo a : articulos.values()) {
                char seccion=a.getIdArticulo().charAt(0);
                switch (seccion) {
                    case '1':
                        oosPerifericos.writeObject(a);
                        break;
                    case '2':
                        oosAlmacenamiento .writeObject(a);
                        break;
                    case '3':
                        oosImpresoras.writeObject(a);
                        break;
                    case '4':
                        oosMonitores.writeObject(a);
                        break;
                }
            }
            System.out.println("Copia de seguridad realizada con éxito.");
	    
        } catch (FileNotFoundException e) {
                 System.out.println(e.toString());                                                          
        } catch (IOException e) {
                 System.out.println(e.toString());
        } 
        /* PARA COMPROBAR QUE FUNCIONA, VERIFICAMOS QUE SE HAN CREADO LOS 4 ARCHIVOS EN LA CARPETA
        RAÍZ DEL PROYECTO CON LA FECHA Y HORA ACTUAL - 
        ... Y PARA COMPROBAR EL CONTENIDO DE LOS ARCHIVOS LEEREMOS/IMPRIMIREMOS "AL VUELO" SÓLO 1 DE ELLOS
         CUYA SECCION SOLICITAMOS POR TECLADO
        */
                
        System.out.println("Teclea la Seccion de los articulos CUYO ARCHIVO QUIERES COMPROBAR:");        
        char seccion=sc.next().charAt(0);
        String nombreArchivo=null;
        switch (seccion) {
                    case '1':
                        nombreArchivo="Perifericos.dat";
                        break;
                    case '2':
                        nombreArchivo="Almacenamiento.dat";
                        break;
                    case '3':
                        nombreArchivo="Impresoras.dat";
                        break;
                    case '4':
                        nombreArchivo="Monitores.dat";
                        break;
        }
        Articulo a;
        try (ObjectInputStream oisArticulos = new ObjectInputStream(new FileInputStream(nombreArchivo))){
            while ( (a=(Articulo)oisArticulos.readObject()) != null){
                System.out.println(a);
            } 
        } catch (FileNotFoundException e) {
                 System.out.println(e.toString());    
        } catch (EOFException e){
            
        } catch (ClassNotFoundException | IOException e) {
                System.out.println(e.toString()); 
        } 
    }  
    
//</editor-fold>
 
    //<editor-fold defaultstate="collapsed" desc="GESTIÓN  DE  CLIENTES">
    private void MenuClientes() {
        Scanner sc = new Scanner(System.in);
        int opcion=0;
        do {
            System.out.println("\n  \t\t-----GESTION DE CLIENTES-----  \n");
            System.out.println("\t\t1. Crear Cliente");
            System.out.println("\t\t2. Eliminar Clientes");
            System.out.println("\t\t3. Listar Clientes");
            System.out.println("\t\t4. Copia de Seguridad en Texto");
            System.out.println("\t\t5. Leer Archivo de Texto");
            System.out.println("\t\t0. Volver");
            System.out.print("\t\tSeleccione una opción: ");

            opcion=sc.nextInt(); 
            switch (opcion) { 
                case 1:{
                    nuevoCliente();
                    break;
                }
                case 2:{
                    eliminarCliente();
                    break;
                }
                case 3:{
                    listarClientes();
                    break;
                }
                
                case 4:{
                    clientesTxtBackup();
                    break;
                }
                case 5:{
                    clientesTxtLeer();
                    break;
                }
                case 0:{
                    System.out.println("\t\tVolviendo al menú principal...");
                    break;
                }
            }
        }while(opcion !=0);
    }
    
     private void nuevoCliente() {
         String dni, nombre, telefono, email;

    do {
        System.out.print("Deme su DNI: ");
        dni = sc.nextLine().toUpperCase();
        if (!MetodosAux.validarDNI(dni)) {
            System.out.println("DNI no válido. Inténtelo de nuevo.");
        } else if (clientes.containsKey(dni)) {
            System.out.println("Ese cliente ya existe. Intente con otro DNI.");
            return;
        }
    } while (!MetodosAux.validarDNI(dni));

    System.out.print("Deme su NOMBRE: ");
    nombre = sc.nextLine();
    
    do {
        System.out.print("Deme su TELÉFONO: ");
        telefono = sc.nextLine();
        if (!telefono.matches("\\d{9}")) {
            System.out.println("Número de teléfono no válido. Debe tener 9 dígitos.");
        }
    } while (!telefono.matches("\\d{9}"));
    
    do {
        System.out.print("Deme su EMAIL: ");
        email = sc.nextLine();
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            System.out.println("Correo electrónico no válido. Inténtelo de nuevo.");
        }
    } while (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$"));

    Cliente c = new Cliente(dni, nombre, telefono, email);
    clientes.put(dni, c);
    System.out.println("Cliente añadido correctamente.");
    }
    
     private void eliminarCliente() {
         System.out.println("HOLA");
    }
    
     
    private void listarClientes() {
         
        ArrayList<Cliente> clientesAux = new ArrayList(clientes.values());
        System.out.println("");
        System.out.println("----- LISTAR CLIENTES -----");
        Collections.sort(clientesAux);
        for (Cliente c : clientesAux) {
            System.out.println(c);
        }
        
        System.out.println("");
        System.out.println("----- AL REVÉS -----");
        
        Collections.reverse(clientesAux);
        for (Cliente c : clientesAux) {
            System.out.println(c);
        }
    }
   
  public void clientesTxtBackup() {
        try(BufferedWriter bfwClientes=new BufferedWriter(new FileWriter("clientes.csv"))){
            for (Cliente c : clientes.values()) {
                bfwClientes.write(c.getDni() + "," + c.getNombre() + "," + c.getTelefono() + "," + c.getEmail() + "\n");
            }
        }catch (FileNotFoundException e) {
                 System.out.println(e.toString());   
        }catch(IOException e){
            System.out.println(e.toString());
        }
    }  
    
    public void clientesTxtLeer() {
        // LEEMOS LOS CLIENTES DESDE EL ARCHIVO .csv A UNA COLECCION HASHMAP AUXILIAR Y LA IMPRIMIMOS
        HashMap <String,Cliente> clientesAux = new HashMap();
        try(Scanner scClientes=new Scanner(new File("clientes.csv"))){
            while (scClientes.hasNextLine()){
                String [] atributos = scClientes.nextLine().split("[,]");                                                              
                Cliente c=new Cliente(atributos[0],atributos[1],atributos[2],atributos[3]); 
                clientesAux.put(atributos[0], c);
            }
        }catch(IOException e){
            System.out.println(e.toString());
        }
        clientesAux.values().forEach(System.out::println);
    }  
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="PERSISTENCIA">
    public void backup() {
    try (ObjectOutputStream oosArticulos = new ObjectOutputStream(new FileOutputStream ("articulos.dat"));
         ObjectOutputStream oosClientes = new ObjectOutputStream(new FileOutputStream ("clientes.dat"));
         ObjectOutputStream oosPedidos = new ObjectOutputStream(new FileOutputStream ("pedidos.dat")))  {
            
        //GUARDANDOLO TODO OBJETO POR OBJETO
        
        for (Articulo a : articulos.values()) {
            oosArticulos.writeObject(a);
        }
        for (Cliente c : clientes.values()) {
            oosClientes.writeObject(c);
        }
        for (Pedido p : pedidos) {
            oosPedidos.writeObject(p);
        }
        
        /**SE GUARDA EL HASMAP ENTERO Y NO EL OBJETO EN SÍ
        // COLECCIONES COMPLETAS
        oosArticulos.writeObject(articulos);
        oosClientes.writeObject(clientes);
         
        //LOS PEDIDOS SE GUARDAN OBJETO A OBJETO
        for (Pedido p : pedidos) {
            oosPedidos.writeObject(p);
        }
        */
    
        System.out.println("Copia de Seguridad realizada con exito :D");
        
    } catch (FileNotFoundException e) {
        System.out.println(e.toString());
    } catch (IOException e){
        System.out.println(e.toString());
    }
}
    
    /**
     *      //SE IMPORTAN TODO LOS OBJETOS DEL HASMAP DEL TIRON
            articulos= (HashMap <String,Articulo>) oisArticulos.readObject();
            clientes= (HashMap <String,Cliente>) oisClientes.readObject();
            
            //LOS PEDIDOS SE IMPORTAN OBJETO A OBJETO
            Pedido p=null;
            while ( (p=(Pedido)oisPedidos.readObject()) !=null) {
                pedidos.add(p);
            }
            */
    public void leerArchivos(){
        
        //LEER ARTICULOS
        try (ObjectInputStream oisArticulos = new ObjectInputStream(new FileInputStream ("articulos.dat"))){
            //LEER TODO OBJETO A OBJETO
            Articulo a;
            while ( (a=(Articulo)oisArticulos.readObject()) !=null) {
                articulos.put(a.getIdArticulo(),a);
            }  

    } catch (FileNotFoundException e) {
        System.out.println(e.toString());
    } catch (EOFException e){
        
    } catch (ClassNotFoundException | IOException e){
        System.out.println(e.toString());
    }
        
        //LEER CLIENTES
        try (ObjectInputStream oisClientes = new ObjectInputStream(new FileInputStream ("clientes.dat"))){
            //LEER TODO OBJETO A OBJETO
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
        
        //LEER PEDIDOS
        try (ObjectInputStream oisPedidos = new ObjectInputStream(new FileInputStream ("pedidos.dat"))){
            //LEER TODO OBJETO A OBJETO
            Pedido p;
            while ( (p=(Pedido)oisPedidos.readObject()) !=null) {
                pedidos.add(p);
            } 

    } catch (FileNotFoundException e) {
        System.out.println(e.toString());
    } catch (EOFException e){
        
    } catch (ClassNotFoundException | IOException e){
        System.out.println(e.toString());
    }

       System.out.println("Colecciones importadas con exito :D");
}
       
//</editor-fold>
   
    
//<editor-fold defaultstate="collapsed" desc="METODOS EXTRAS">
    public void ordenarPedidosPorFechaAscendente() {
    pedidos.sort(Comparator.comparing(Pedido::getFechaPedido));
}

public void ordenarPedidosPorFechaDescendente() {
    pedidos.sort(Comparator.comparing(Pedido::getFechaPedido).reversed());
}
    
public void ordenarArticulosPorPrecio() {
    articulos.values().stream()
            .sorted(Comparator.comparing(Articulo::getPvp))
            .forEach(System.out::println);
}
    
public void ordenarClientesPorNombre() {
    ArrayList<Cliente> listaClientes = new ArrayList<>(clientes.values());
    listaClientes.sort(Comparator.comparing(Cliente::getNombre));
    
    for (Cliente c : listaClientes) {
        System.out.println(c);
    }
}
    




// Método auxiliar que calcula cuántos artículos hay en un pedido
public int cantidadTotalArticulos(Pedido p) {
    return p.getCestaCompra().stream()  // Convertimos la lista de artículos en un stream
            .mapToInt(LineaPedido::getUnidades) // Obtenemos la cantidad de cada artículo
            .sum(); // Sumamos todas las cantidades
}

// Método que ordena los pedidos en función del total de artículos comprados
public void ordenarPedidosPorCantidadArticulos() {
    pedidos.stream()
            .sorted(Comparator.comparing(this::cantidadTotalArticulos)) // Ordena por cantidad total
            .forEach(System.out::println); // Muestra los pedidos ordenados
}




/**
 * public void ordenarArticulosStockDisponible() {
    Scanner sc = new Scanner(System.in);
    
    System.out.println("¿Quieres ver primero los artículos con stock? (S/N)");
    String opcion = sc.nextLine().toUpperCase();

    articulos.values().stream()
            .sorted(opcion.equals("S") ? 
                Comparator.comparing(a -> a.getExistencias() == 0) : 
                Comparator.comparing(a -> a.getExistencias() > 0))
            .forEach(System.out::println);
}
 */
public void ordenarArticulosStockDisponible() {
    articulos.values().stream()
            .sorted(Comparator.comparing(a -> a.getExistencias() == 0)) // Los de stock 0 al final
            .forEach(System.out::println); // Muestra los artículos ordenados
}






// Método auxiliar que cuenta los pedidos de un cliente
public int contarPedidosCliente(String dni) {
    return (int) pedidos.stream()
            .filter(p -> p.getClientePedido().getDni().equals(dni)) // Filtra pedidos del cliente
            .count(); // Cuenta los pedidos
}

// Método que ordena los clientes según la cantidad de pedidos que han hecho
public void ordenarClientesPorPedidos() {
    ArrayList<Cliente> listaClientes = new ArrayList<>(clientes.values()); // Convertimos en lista
    listaClientes.sort(Comparator.comparing(c -> contarPedidosCliente(c.getDni()), Comparator.reverseOrder())); 
    // Ordenamos de mayor a menor número de pedidos

    listaClientes.forEach(System.out::println); // Mostramos la lista ordenada
}






// Método auxiliar que calcula cuánto ha gastado un cliente en total
public double calcularGastoTotalCliente(String dni) {
    return pedidos.stream()
            .filter(p -> p.getClientePedido().getDni().equals(dni)) // Filtra los pedidos del cliente
            .mapToDouble(this::totalPedido) // Obtiene el total gastado en cada pedido
            .sum(); // Suma todos los gastos
}

/**
 * public void ordenarPedidosClientesVIP() {
    Scanner sc = new Scanner(System.in);

    System.out.println("Introduce el DNI del cliente:");
    String dni = sc.nextLine().toUpperCase();

    double gastoTotal = calcularGastoTotalCliente(dni);

    if (gastoTotal > 500) {
        System.out.println("El cliente con DNI " + dni + " es VIP. Ha gastado: " + gastoTotal + "€");
    } else {
        System.out.println("El cliente con DNI " + dni + " NO es VIP. Ha gastado: " + gastoTotal + "€");
    }
}

 */
// Método que filtra clientes VIP (más de 500€ gastados) y ordena sus pedidos por importe total
public void ordenarPedidosClientesVIP() {
    pedidos.stream()
            .filter(p -> calcularGastoTotalCliente(p.getClientePedido().getDni()) > 500) // Filtra VIP
            .sorted(Comparator.comparing(this::totalPedido).reversed()) // Ordena de mayor a menor gasto
            .forEach(System.out::println); // Muestra los pedidos ordenados
}




// Método auxiliar que calcula cuántas veces se ha vendido un artículo
public int cantidadTotalVendida(String idArticulo) {
    return pedidos.stream()
            .flatMap(p -> p.getCestaCompra().stream()) // Accede a todas las líneas de pedidos
            .filter(lp -> lp.getIdArticulo().equals(idArticulo)) // Filtra por ID de artículo
            .mapToInt(LineaPedido::getUnidades) // Obtiene las cantidades compradas
            .sum(); // Suma todas las compras del artículo
}
/**
 * public void ordenarArticulosPorDemanda() {
    System.out.print("Ingrese la cantidad mínima de ventas: ");
    int minVentas = sc.nextInt();
    
    System.out.print("Ingrese la cantidad máxima de ventas: ");
    int maxVentas = sc.nextInt();

    articulos.values().stream()
            .filter(a -> {
                int ventas = cantidadTotalVendida(a.getIdArticulo());
                return ventas >= minVentas && ventas <= maxVentas;
            }) // Filtra por demanda
            .sorted(Comparator.comparing(a -> cantidadTotalVendida(a.getIdArticulo()), Comparator.reverseOrder()))
            .forEach(System.out::println);
}
 */
// Método que ordena los artículos por demanda, de mayor a menor
public void ordenarArticulosPorDemanda() {
    articulos.values().stream()
            .sorted(Comparator.comparing(a -> cantidadTotalVendida(a.getIdArticulo()), Comparator.reverseOrder()))
            .forEach(System.out::println); // Muestra los artículos ordenados
}

    
    public long contarClientesConPedidos() {
    return pedidos.stream()
            .map(p -> p.getClientePedido().getDni())
            .distinct()
            .count();
}
    public double calcularValorInventario() {
    return articulos.values().stream()
            .mapToDouble(a -> a.getExistencias() * a.getPvp())
            .sum();
}
    
    //Una clase que tendremos que poner en un archivo distinto
    public class ComparaArticulosPorNombre implements Comparator<Articulo> {

    @Override
    public int compare(Articulo a1, Articulo a2) {
        return a1.getDescripcion().compareToIgnoreCase(a2.getDescripcion());
    }
}
    
    public void ordenarArticulosPorNombre() {
    articulos.values().stream()
            .sorted(new ComparaArticulosPorNombre()) // Usa el comparador creado
            .forEach(System.out::println);
}
    
    public double totalGastadoPorCliente(String dni) {
    return pedidos.stream()
            .filter(p -> p.getClientePedido().getDni().equals(dni)) // Filtra pedidos del cliente
            .mapToDouble(this::totalPedido) // Obtiene el total de cada pedido
            .sum(); // Suma los totales
}
    public List<Articulo> obtenerArticulosAgotados() {
    return articulos.values().stream()
            .filter(a -> a.getExistencias() == 0) // Filtra los sin stock
            .toList(); // Devuelve la lista
}
    public void listarPedidosPorImporte() {
    pedidos.stream()
           .sorted(Comparator.comparing(this::totalPedido).reversed())
           .forEach(System.out::println);
}
    public void aplicarDescuento(double porcentaje) {
    articulos.values().forEach(a -> a.setPvp(a.getPvp() * (1 - porcentaje / 100)));
}
    
   public Articulo obtenerArticuloMasVendido() {
    return articulos.values().stream()
            .max(Comparator.comparing(a -> cantidadTotalVendida(a.getIdArticulo()))) // Compara por cantidad vendida
            .orElse(null); // Devuelve null si no hay artículos
}
//</editor-fold>
   
   
   
}
