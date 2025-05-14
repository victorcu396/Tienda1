/**
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package dawvictormm.tienda2025;

        //<editor-fold defaultstate="collapsed" desc="IMPORTS">
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

//</editor-fold>

/**
 *
 * @author alu16d
 */

public class Tienda2025 {

    Scanner sc=new Scanner(System.in);
    private ArrayList<Pedido> pedidos;
    private HashMap <String, Articulo> articulos;
    private HashMap <String, Cliente> clientes;
    
    //<editor-fold defaultstate="collapsed" desc="GETTERS">
    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
    public HashMap<String, Articulo> getArticulos() {
        return articulos;
    }
    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }
//</editor-fold>
    
    
    public Tienda2025() {
        pedidos = new ArrayList<>();
        articulos = new HashMap<>();
        clientes = new HashMap<>();
    }

     public static void main(String[] args) {
       Tienda2025 t=new Tienda2025();
       t.leerArchivos();
       t.cargaDatos();
       t.mostrarMenuPrincipal();
       t.backup();
       
     }
     
 //<editor-fold defaultstate="collapsed" desc="CARGA  DATOS">
       public void cargaDatos(){
       clientes.put("90015161S",new Cliente("90015161S","ANA ","658111111","ana@gmail.com"));
       clientes.put("96819473F",new Cliente("96819473F","ANTONIO","649222222","antonio@gmail.com"));
       clientes.put("95767515T",new Cliente("95767515T","AURORA","652333333","aurora@gmail.com"));
       clientes.put("97801164N",new Cliente("97801164N","EMILIO","649222222","emilio@gmail.com"));
       clientes.put("58440531S",new Cliente("58440531S","EVA","652333333","eva@gmail.com"));
         
       
       articulos.put("1-11",new Articulo("1-11","RATON LOGITECH ST ",14,15));
       articulos.put("1-22",new Articulo("1-22","TECLADO STANDARD  ",9,18));
       articulos.put("2-11",new Articulo("2-11","HDD SEAGATE 1 TB  ",16,80));
       articulos.put("2-22",new Articulo("2-22","SSD KINGSTOM 256GB",0,70));
       articulos.put("2-33",new Articulo("2-33","SSD KINGSTOM 512GB",5,200));
       articulos.put("3-22",new Articulo("3-22","EPSON PRINT XP300 ",5,80));
       articulos.put("4-11",new Articulo("4-11","ASUS  MONITOR  22 ",10,100));
       articulos.put("4-22",new Articulo("4-22","HP MONITOR LED 28 ",5,180));
      
       LocalDate hoy = LocalDate.now();
       pedidos.add(new Pedido("90015161S-001/2025",clientes.get("90015161S"),hoy.minusDays(1), new ArrayList<>
        (List.of(new LineaPedido("2-33",5),new LineaPedido("4-11",5)))));                                                                                                                                                               
       pedidos.add(new Pedido("90015161S-002/2025",clientes.get("90015161S"),hoy.minusDays(2), new ArrayList<>
        (List.of(new LineaPedido("2-11",5),new LineaPedido("4-11",1)))));
       pedidos.add(new Pedido("96819473F-001/2025",clientes.get("96819473F"),hoy.minusDays(3), new ArrayList<>
        (List.of(new LineaPedido("4-22",1),new LineaPedido("2-22",3)))));
       pedidos.add(new Pedido("95767515T-001/2025",clientes.get("95767515T"),hoy.minusDays(5), new ArrayList<>
        (List.of(new LineaPedido("1-11",3),new LineaPedido("2-11",3)))));
       pedidos.add(new Pedido("97801164N-001/2025",clientes.get("97801164N"),hoy.minusDays(4), new ArrayList<>
        (List.of(new LineaPedido("2-11",1),new LineaPedido("2-33",3),new LineaPedido("1-11",2)))));
    } 
    
//</editor-fold>     
  
    
       //<editor-fold defaultstate="collapsed" desc="EXTRAS  con  MENU">
       
       private void MenuExtras() {
        Scanner sc = new Scanner(System.in);
        int opcion=0;
        do {
            System.out.println("\n  \t\t-----GESTION DE EJERCICIOS EXTRAS-----  \n");
            System.out.println("\t\t1. Mostrar clientes con y sin pedidos");
            System.out.println("\t\t2. Mostrar clientes con y sin pedidos y el dinero gastado");
            System.out.println("\t\t3. Pedidos ordenados por articulos vendidos");
            System.out.println("\t\t4. Listar Articulos por Seccion");
            System.out.println("\t\t5. Listar Usuarios que han comprado un artículo específico y el nº de veces");
            System.out.println("\t\t6. Pedidos ordenados por importe");
            System.out.println("\t\t7. Clientes ordenados por gastos");
            System.out.println("\t\t0. Volver");
            System.out.print("\t\tSeleccione una opción: ");

            opcion=sc.nextInt(); 
            switch (opcion) { 
                case 1:{
                    cientesConSinPedidos();
                    break;
                }
                case 2:{
                    cientesConSinPedidosyDineroGastado();
                    break;
                }
                case 3:{
                    pedidosOrdenadosPorArticuloVendido();
                    break;
                }
                case 4:{
                    listarArticulosPorSeccion();
                    break;
                }
                case 5:{
                    articuloUsuariosLoHanComprado();
                    break;
                }
                case 6:{
                    perdidosOrdenadosPorImporte();
                    break;
                }
                case 7:{
                    clientesOrdenadosPorGasto();
                    break;
                }
                case 0:{
                    System.out.println("\t\tVolviendo al menú principal...");
                    break;
                }
            }
        }while(opcion !=0);
    }
       
       
       
       
       
    public void cientesConSinPedidos(){
        ArrayList<Cliente> clientesSin = new ArrayList();
        ArrayList<Cliente> clientesCon = new ArrayList();
               
        try(BufferedWriter bfwClientesCon=new BufferedWriter(new FileWriter("clientesCon.csv"));
            BufferedWriter bfwClientesSin=new BufferedWriter(new FileWriter("clientesSin.csv"))    ){
            
            for (Cliente c : clientes.values()) {
                /* ESTILO CLÁSICO 
                boolean tienePedido = false;
                for (Pedido p : pedidos) {
                    if (p.getClientePedido() == c) {
                        tienePedido = true;
                        break;
                    }
                } 
                if (tienePedido) {
                   bfwClientesCon.write(c.getDni() + "," + c.getNombre() + "," + c.getTelefono() + "," + c.getEmail() + "\n");
                } else{
                   bfwClientesSin.write(c.getDni() + "," + c.getNombre() + "," + c.getTelefono() + "," + c.getEmail() + "\n"); clientesSin.add(c);
                }*/

                /* CON STREAMS Y EL METODO anyMatch */
                if (pedidos.stream().anyMatch(p-> p.getClientePedido().equals(c))){
                   bfwClientesCon.write(c.getDni() + "," + c.getNombre() + "," + c.getTelefono() + "," + c.getEmail() + "\n");
                } else{
                   bfwClientesSin.write(c.getDni() + "," + c.getNombre() + "," + c.getTelefono() + "," + c.getEmail() + "\n");
                }
            }
        }catch (FileNotFoundException e) {
                 System.out.println(e.toString());   
        }catch(IOException e){
            System.out.println(e.toString());
        }
 
        try(Scanner scClientesCon=new Scanner(new File("clientesCon.csv"))){
            while (scClientesCon.hasNextLine()){
                String [] atributos = scClientesCon.nextLine().split("[,]");                                                              
                Cliente c=new Cliente(atributos[0],atributos[1],atributos[2],atributos[3]); 
                clientesCon.add(c);
            }
        }catch(IOException e){
            System.out.println(e.toString());
        }
        
        try(Scanner scClientesSin=new Scanner(new File("clientesSin.csv"))){
            while (scClientesSin.hasNextLine()){
                String [] atributos = scClientesSin.nextLine().split("[,]");                                                              
                Cliente c=new Cliente(atributos[0],atributos[1],atributos[2],atributos[3]); 
                clientesSin.add(c);
            }
        }catch(IOException e){
            System.out.println(e.toString());
        }
        System.out.println("\nCLIENTES CON PEDIDOS:");
        clientesCon.forEach(System.out::println);
        System.out.println("\nCLIENTES SIN PEDIDOS:");
        clientesSin.forEach(System.out::println);
    }
    
    
    public void cientesConSinPedidosyDineroGastado(){
        ArrayList<Cliente> clientesSin = new ArrayList();
        ArrayList<Cliente> clientesCon = new ArrayList();
        ArrayList<Cliente> clientesMas1000 = new ArrayList();
               
        try(BufferedWriter bfwClientesCon=new BufferedWriter(new FileWriter("clientesCon.csv"));
            BufferedWriter bfwClientesSin=new BufferedWriter(new FileWriter("clientesSin.csv"));
            BufferedWriter bfwClientesMas1000=new BufferedWriter(new FileWriter("clientesMas1000.csv")))
        {
        /* USAMOS EL MÉTODO totalCliente(c) PARA CALCULAR EL TOTAL GASTADO POR UN CLIENTE EN TODOS SUS PEDIDOS
           DESPUÉS VEREMOS ALTERNATIVAS CON PROGRAMACIÓN FUNCIONAL PARA DESARROLLAR ESTE MÉTODO
            
           EN ESTA VERSION DEL EJERCICIO SABEMOS QUE UN CLIENTE CON GASTO>1000 O  >0 TIENE PEDIDOS, EL RESTO NO
        */    
            for (Cliente c : clientes.values()){
                if (totalCliente(c)==0){
                    bfwClientesSin.write(c.getDni() + "," + c.getNombre() + "," + c.getTelefono() + "," + c.getEmail() + "\n");
                }else if (totalCliente(c)>=1000){
                      bfwClientesCon.write(c.getDni() + "," + c.getNombre() + "," + c.getTelefono() + "," + c.getEmail() + "\n");
                      bfwClientesMas1000.write(c.getDni() + "," + c.getNombre() + "," + c.getTelefono() + "," + c.getEmail() + "\n");
                    }else {
                       bfwClientesCon.write(c.getDni() + "," + c.getNombre() + "," + c.getTelefono() + "," + c.getEmail() + "\n");
                    }
            }
            /* EXACTAMENTE LO MISMO SE PUEDE HACER ESTRUCTURANDO LAS CONDICIONES DE OTRA FORMA     
                if (totalCliente(c)>0){
                    bfwClientesCon.write(c.getDni() + "," + c.getNombre() + "," + c.getTelefono() + "," + c.getEmail() + "\n");
                    bfwClientesMas1000.write(c.getDni() + "," + c.getNombre() + "," + c.getTelefono() + "," + c.getEmail() + "\n");
                   
                }else if (totalCliente(c)>0){
                       bfwClientesCon.write(c.getDni() + "," + c.getNombre() + "," + c.getTelefono() + "," + c.getEmail() + "\n");
                    }else {
                        bfwClientesSin.write(c.getDni() + "," + c.getNombre() + "," + c.getTelefono() + "," + c.getEmail() + "\n");
                    }
            */
            
        }catch (FileNotFoundException e) {
                 System.out.println(e.toString());   
        }catch(IOException e){
            System.out.println(e.toString());
        }
 
        try(Scanner scClientesCon=new Scanner(new File("clientesCon.csv"))){
            while (scClientesCon.hasNextLine()){
                String [] atributos = scClientesCon.nextLine().split("[,]");                                                              
                Cliente c=new Cliente(atributos[0],atributos[1],atributos[2],atributos[3]); 
                clientesCon.add(c);
            }
        }catch(IOException e){
            System.out.println(e.toString());
        }
        
        try(Scanner scClientesSin=new Scanner(new File("clientesSin.csv"))){
            while (scClientesSin.hasNextLine()){
                String [] atributos = scClientesSin.nextLine().split("[,]");                                                              
                Cliente c=new Cliente(atributos[0],atributos[1],atributos[2],atributos[3]); 
                clientesSin.add(c);
            }
        }catch(IOException e){
            System.out.println(e.toString());
        }
        
        try(Scanner scClientesSin=new Scanner(new File("clientesMas1000.csv"))){
            while (scClientesSin.hasNextLine()){
                String [] atributos = scClientesSin.nextLine().split("[,]");                                                              
                Cliente c=new Cliente(atributos[0],atributos[1],atributos[2],atributos[3]); 
                clientesMas1000.add(c);
            }
        }catch(IOException e){
            System.out.println(e.toString());
        }
        System.out.println("\nCLIENTES CON PEDIDOS:");
        clientesCon.forEach(System.out::println);
        System.out.println("\nCLIENTES SIN PEDIDOS:");
        clientesSin.forEach(System.out::println);
        System.out.println("\nCLIENTES CON MAS DE 1000€ GASTADOS:");
        clientesMas1000.forEach(System.out::println);
    }
    
    
    public void pedidosOrdenadosPorArticuloVendido(){
        String id;
        do{
            System.out.println("Teclea idArticulo para contabilizar en pedidos:");
            id=sc.next();
        }while(!articulos.containsKey(id));
        
        System.out.println("Unidades vendidas del artículo: " + articulos.get(id).getDescripcion());
       
        final String id2 = id;
        pedidos.stream().sorted(Comparator.comparing(p-> articuloEnPedido2(id2, (Pedido)p)).reversed()).
                forEach(p-> System.out.println("Pedido " +p.getIdPedido() + "-" + p.getFechaPedido()  
                     + " : " + articuloEnPedido2(id2,p) + " unidades"  ));
    }  
      
    /* METODO articuloEnPedido CLÁSICO */
    public int articuloEnPedido(String idArticulo, Pedido p){
       int contador=0;
       for (LineaPedido l:p.getCestaCompra()){
           if (l.getIdArticulo().equals(idArticulo)){
               contador+=l.getUnidades();
               break;
           }
       }
       return contador;
    }
    
    /* MÉTODO articuloEnPedido PROGRAMACIÓN FUNCIONAL */
         
    public int articuloEnPedido2(String idArticulo, Pedido p){
        return p.getCestaCompra().stream().filter(l->l.getIdArticulo().equals(idArticulo))
            .mapToInt(LineaPedido::getUnidades).sum();
    }
    
    
       
    /****************************************************************************************
        EJERCICIO - LISTADO DE USUARIOS QUE HAN COMPRADO UN ARTÍCULO DETERMINADO 
                        
        IMPORTANTE TENER EN CUENTA QUE UN USUARIO PUEDE HABER COMPRADO EL MISMO ARTÍCULO EN PEDIDOS
        DISTINTOS Y NO DEBEN DE SALIR VARIAS LÍNEAS EN EL LISTADO PARA ESE USUARIO/A. 
        DEBE DE SALIR UNA ÚNICA LÍNEA CON EL TOTAL DE UNIDADES DEL ARTÍCULO COMPRADAS POR EL USUARIO
        ESTO ES UNA COMPLEJIDAD PARA EL EJERCICIO 
    *****************************************************************************************/
    public void articuloUsuariosLoHanComprado(){
        String id;
        do{
            System.out.println("Teclea idArticulo para contabilizar en pedidos:");
            id=sc.next();
        }while(!articulos.containsKey(id));
        
        System.out.println("Usuarios que han comprado el articulo: " + articulos.get(id).getDescripcion());
        
        /* METODO CLÁSICO 
        for (Cliente c:clientes.values()){
            int unidades=0;
            for (Pedido p:pedidos){
                if (p.getClientePedido().equals(c)){
                    for(LineaPedido l:p.getCestaCompra()){
                        if (l.getIdArticulo().equals(id)){
                            unidades+= l.getUnidades();
                        }
                    }
                }
            }
            if (unidades>0){
                System.out.println(c.getNombre()+
                  " ha comprado " + unidades + " unidades") ;
            }
        }*/
        
        // STREAMS 
        final String id2=id;
        for (Cliente c:clientes.values()){
            int unidades= pedidos.stream().filter(p-> p.getClientePedido().equals(c))
                    .mapToInt(p -> p.getCestaCompra().stream().filter(l->l.getIdArticulo().equals(id2))
                        .mapToInt(LineaPedido::getUnidades).sum()).sum();     
            
            if (unidades>0){
                System.out.println(c.getNombre() + ": " + unidades);
            }
        }                   
    }
    
    
    
    
    /**************************************************************************************
    ALGUNAS ORDENACIONES RELIZADAS CON COMPARATORS APOYADAS EN LOS METODOS totalPedido() totalCliente() 
    ***************************************************************************************/
    
    
    public void perdidosOrdenadosPorImporte(){
        pedidos.stream().sorted(Comparator.comparing(p->totalPedido((Pedido) p))
            .reversed()).forEach(p-> System.out.println(p.getIdPedido() + ":\t "+ totalPedido(p)));
    }
    
    public void clientesOrdenadosPorGasto(){
        clientes.values().stream().sorted(Comparator.comparing(c->totalCliente((Cliente) c))
            .reversed()).forEach(c-> System.out.println(c.getNombre() + ":\t "+ totalCliente(c)));
    }
    
         /* EJERCICIO CON STREAMS DE LISTADOS DE ARTÍCULOS POR SECCIÓN */
    public void listarArticulosPorSeccion() {
        Scanner sc=new Scanner(System.in);
        String opcion;
        do{
            System.out.println("\n\n\n\n\n\t\t\t\tLISTAR ARTICULOS\n");
            System.out.println("\t\t\t\t0 - TODOS LOS ARTICULOS");
            System.out.println("\t\t\t\t1 - PERIFERICOS");
            System.out.println("\t\t\t\t2 - ALMACENAMIENTO");
            System.out.println("\t\t\t\t3 - IMPRESORAS");
            System.out.println("\t\t\t\t4 - MONITORES");
            System.out.println("\t\t\t\t9 - SALIR");
            do
                opcion=sc.next();
            while (!opcion.matches("[0-4,9]"));
            if (opcion!="9"){
                listados(opcion);
            }
        }while (!opcion.equals("9"));
    }
    public void listados (String seccion){
        String[] secciones={"TODAS","PERIFERICOS","ALMACENAMIENTO","IMPRESORAS","MONITORES"};
        int s=Integer.parseInt(seccion);
        if (seccion.equals("0")){ 
            System.out.println("LISTADO ARTICULOS DE LA SECCION: " + secciones[s]);
            articulos.values().stream().forEach(System.out::println);
        } else{
            System.out.println("LISTADO ARTICULOS DE LA SECCION: " + secciones[s]);
            articulos.values().stream().filter(a -> a.getIdArticulo().startsWith(seccion))
                    .forEach(System.out::println);
        }
    }
    
     /* PARA HACER LISTADOS ORDENADOS TAN SOLO HAY QUE AÑADIR .sorted() al stream()
    
    Si no le pasamos argumento al sorted() Java buscará en la clase Articulo a ver si hemos 
    implementado el interface Comparable y usará el criterio que hayamos programado en el método
    public int compareTo(Articulo a)
    
    Si creamos clases Comparator propias podemos usarlas para definir nuestras propias ordenaciones
    o bien utilizar el método Comparator.comparing(predicado)
    
    También podemos cambiar el sentido de las ordenaciones con .reversed();
    
    LAS POSIBILIDADES SON ILIMITADAS Y SE TRATA DE PROBAR, PROBAR Y PROBAR
    */
    
    
    
    
    
       /*************************************************************************************
    * EJERCICIO DE BACKUPS DE PEDIDOS POR CLIENTE - 1 ARCHIVO DE PEDIDOS POR CADA CLIENTE
    ***************************************************************************************/
    
    public void backupPedidosClientes() {
        boolean tienePedidos; 
        for (Cliente c:clientes.values()){
            tienePedidos=false;       
            for (Pedido p: pedidos ){
                if(p.getClientePedido().equals(c)){
                    tienePedidos=true;
                    break;
                }
            }
            if (tienePedidos){
                String archivo="PedidosCliente_" + c.getNombre()+".dat";
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo)))
                {
                   for (Pedido p: pedidos ){
                        if(p.getClientePedido().equals(c)) {
                            oos.writeObject(p);
                        }
                   }
                } catch (IOException e) {
                   System.out.println(e.toString());
                } 
                
            }
        }
        System.out.println("ARCHIVOS CREADOS CORRECTAMENTE\n");
        
        /*AHORA SOLICITAMOS EL DNI DE UN CLIENTE PARA MOSTRAR SUS PEDIDOS
        DESDE EL ARCHIVO .dat CORRESPONDIENTE
        */ 
        String dniT; 
        //NO PERMITIMOS ENTRADA DE DNIs NO VÁLIDOS O QUE NO ESTÁN EN LA TIENDA
        do{
            System.out.println("DNI CLIENTE:");
            dniT=sc.next().toUpperCase();    
        }while (!clientes.containsKey(dniT)||!MetodosAux.validarDNI(dniT));
        
        //COMPROBAMOS AHORA SI EL DNI TIENE PEDIDOS.
        //SI NO LOS TIENE NO SE CREÓ SU ARCHIVO
        tienePedidos=false;       
        for (Pedido p: pedidos ){
            if(p.getClientePedido().equals(clientes.get(dniT))) {
                tienePedidos=true;
                break;
            }
        }
        
        if (tienePedidos){
            String archivo="PedidosCliente_" + clientes.get(dniT).getNombre()+".dat";
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo)))
            {
                Pedido p=null;
                while ( (p=(Pedido)ois.readObject()) != null){
                     System.out.println("\nPEDIDO: " + p.getIdPedido() + " DE: " + p.getClientePedido().getNombre());
                     for (LineaPedido l:p.getCestaCompra()){
                         System.out.println(articulos.get(l.getIdArticulo()).getDescripcion()
                                 + "\t Unidades: " +l.getUnidades());
                     }
                } 
            } catch (EOFException e) {
                System.out.println("Fin archivo");
            } catch (IOException e) {
                System.out.println("No existen pedidos para ese DNI");
            } catch (ClassNotFoundException ex) {
            }
        }
    }
    
    

        /******************************************
    EJEMPLOS VARIOS DE USO API STREAMS .collect
    *******************************************/  
    
    public void apiStreams(){
                   
        /* .collect() PERMITE "RECOLECTAR" LOS RESULTADOS DE PROCESAR LOS OBJETOS DE UN STREAM
        Y ALMACENARLOS EN CUALQUIER OTRA COLECCIÓN LIST-SET-MAP DESPUES DE HACERLES CUALQUIER
        TIPO DE PROCESAMIENTO QUE PODAMOS IMAGINAR. 
        
            .collect(Collectors.toList())
            .collect(Collectors.toSet())
            .collect(Collectors.toMap())
        
        utilizando  .map()
        LOS OBJETOS LOS PODREMOS "RECOLECTAR" COMPLETOS, O SÓLO EL ATRIBUTO O PARTE DEL ATRIBUTO
        QUE NOS INTERESE, ADEMÁS DE PODER AÑADIR A LA NUEVA COLECCIÓN VALORES CALCULADOS "A MAYORES"
        */
           
        /*****************************************************************************************
        EJEMPLO1 : ¿Cuántos artículos hay en cada Sección?
        ******************************************************************************************
        
        UTILIZANDO EL MÉTODO .Collectors.groupingBy() agrupo los articulos por secciones
        y para saber cuantos hay de cada seccion "cuenteo" el agrupamiento con Collectors.counting()

        previamente aislamos/mapeamos (map) la sección de cada articulo (primer caracter del atributo idArticulo)
        */
        
        Map<Character,Long> articulosEnSeccion= articulos.values().stream()
               .map(a->a.getIdArticulo().charAt(0))
               .collect(Collectors.groupingBy(a->a,Collectors.counting()));
        
        System.out.println(articulosEnSeccion);
        System.out.println("");
        
        /*EN PROGRAMACIÓN CLÁSICA PODEMOS OBTENER LOS MISMOS RESULTADOS
        PERO ES MÁS COMPLICADO YA QUE EL HASHMAP DE ARTICULOS NO ESTÁ ORDENADO
        Y NECESITAMOS USAR UNA LISTA AUXILIAR*/
        
        List <Articulo> articulosOrd= articulos.values().stream()
                .sorted(Comparator.comparing(Articulo::getIdArticulo))
                .collect(Collectors.toList());
        
        //UNA VEZ ORDENADA LA LISTA VAMOS CONTABILIZANDO SECCIONES
        HashMap<Character,Long> articulosEnSeccion2=new HashMap();
        char seccn='1';
        long total=0;
        for (Articulo a:articulosOrd){
            if ((a.getIdArticulo().charAt(0)==seccn)){
                total++;
            }else {
                articulosEnSeccion2.put(seccn,total);
                seccn=a.getIdArticulo().charAt(0);
                total=1;
            }      
        }
        //PARA ESCRIBIR EN EL HASHMAP LA ÚLTIMA SECCIÓN O SINO LA PERDERÍAMOS
        articulosEnSeccion2.put(seccn,total);
        
        
        for (char s:articulosEnSeccion2.keySet()){
            System.out.println("En la SECCIÓN: " + s + " hay "
                    + articulosEnSeccion2.get(s) + " artículos");
        }
        
        /********************************************************************************************** 
        EJEMPLO2 : ¿Cuál es el artículo más barato y más caro de una sección introducida por teclado? 
        ***********************************************************************************************/
        
        String seccion;
        do{
            System.out.println("Teclea la Sección para conocer artículo más caro y más barato:");
            seccion=sc.next();
        }while(!seccion.matches("[1-4]"));
        
        
        //TODO CON MÉTODOS DEL API DE STREAMS
        
        final String sec=seccion;
        var max= articulos.values().stream()
               .filter(a->a.getIdArticulo().startsWith(sec))
               .collect(Collectors.maxBy(Comparator.comparing(Articulo::getPvp)));
        
        var min= articulos.values().stream()
               .filter(a->a.getIdArticulo().startsWith(sec))
               .collect(Collectors.minBy(Comparator.comparing(Articulo::getPvp)));
        
        System.out.println(min);
        System.out.println(max);
        
        /* ESTILO CLASICO-MIXTO
        PODEMOS CREAR UN LISTA CON LOS ARTÍCULOS DE ESA SECCIÓN, ORDENARLA POR PRECIO CON UN COMPARATOR
        (OJO PORQUE EL COMPARATOR HAY QUE CREARLO A PARTE)
        Y TOMAR COMO MÁXIMO EL ÚLTIMO Y MÍNIMO EL 1º
        */ 
                    
        List<Articulo> listaMinMax = articulos.values().stream()
             .filter(a->a.getIdArticulo().startsWith(sec))
             .collect(Collectors.toList());
        
        Collections.sort(listaMinMax//, new ComparaArticulosPorPVP()
        );
        System.out.println("");
        System.out.println(listaMinMax.getFirst());
        System.out.println(listaMinMax.getLast());
    }


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
            System.out.println("\t\t6. GESTIÓN DE EXTRAS");
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
                case 6:{
                    MenuExtras();
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
            System.out.println("\t\t2. Eliminar Pedido");
            System.out.println("\t\t3. Listar Pedidos");
            System.out.println("\t\t4. Listar Pedidos Por Total Del Precio");
            System.out.println("\t\t0. Volver");
            System.out.print("\t\tSeleccione una opción: ");

            opcion=sc.nextInt(); 
            switch (opcion) { 
                case 1:{
                    nuevoPedido();
                    break;
                }
                case 2:{
                    eliminarPedido();
                    break;
                }
                case 3:{
                    listarPedidos();
                    break;
                }
                case 4:{
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
     
     public void eliminarPedido() {
        System.out.print("Ingrese el ID del pedido a eliminar: ");
        String idPedido = sc.nextLine();

        boolean eliminado = pedidos.removeIf(p -> {
            if (p.getIdPedido().equals(idPedido)) {
                for (LineaPedido lp : p.getCestaCompra()) {
                    Articulo a = articulos.get(lp.getIdArticulo());
                    if (a != null) {
                        a.setExistencias(a.getExistencias() + lp.getUnidades());
                    }
                }
                return true; // Indica que el pedido debe eliminarse
            }
            return false;
        }
        );

        if (eliminado) {
            System.out.println("Pedido eliminado y stock actualizado.");
        } else {
            System.out.println("Pedido no encontrado.");
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
        /* Versión clásica
        double total=0;
        for (LineaPedido l:p.getCestaCompra())
        {
            total+=(articulos.get(l.getIdArticulo()).getPvp())
                    *l.getUnidades();
        }
        return total;
        */
        // Versión con Streams
        return p.getCestaCompra().stream()
                .mapToDouble(l -> articulos.get(l.getIdArticulo()).getPvp() * l.getUnidades())
                .sum();

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
            System.out.println("\t\t7. jeje");
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
                case 7:{
                    contarArticulosPorSeccion();
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
     
     public void eliminarArticulo() {
        System.out.print("Ingrese el ID del artículo a eliminar: ");
        String idArticulo = sc.nextLine();
        if (articulos.containsKey(idArticulo)) {
            pedidos.forEach(p -> p.getCestaCompra().removeIf(lp -> lp.getIdArticulo().equals(idArticulo)));
            articulos.remove(idArticulo);
            System.out.println("Artículo eliminado correctamente.");
        } else {
            System.out.println("Artículo no encontrado.");
        }
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

    
    public void contarArticulosPorSeccion() {
        articulos.values().stream()
                .collect(Collectors.groupingBy(a -> a.getIdArticulo().charAt(0), Collectors.counting()))
                .forEach((seccion, count) -> System.out.println("Sección " + seccion + ": " + count + " artículos"));
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
                case 6:{
                    informacionArchivo();
                    break;
                }
                case 7:{
                    restaurarPedidosCaros();
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
    
    public void eliminarCliente() {
        System.out.print("Ingrese el DNI del cliente a eliminar: ");
        String dni = sc.nextLine();
        if (clientes.containsKey(dni)) {
            pedidos.removeIf(p -> p.getClientePedido().getDni().equals(dni));
            clientes.remove(dni);
            System.out.println("Cliente eliminado correctamente.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
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


    public double totalCliente(Cliente c) {
        /* Versión clásica
        double total=0;
        for (Pedido p:pedidos)
        {
            if (p.getClientePedido().equals(c)) {
                total+=totalPedido(p);
            }
        }
        return total;
        */
        // Versión con Streams
        return pedidos.stream()
                .filter(p -> p.getClientePedido().equals(c))
                .mapToDouble(this::totalPedido)
                .sum();

    }
    public double totalCliente2(Cliente c) {
        
        
       //hacer el totalCliente, pero sin usar el totalPedido y usando streams y usando dos mapToDouble y sin usar flatMap 
        return pedidos.stream()
         .filter(p -> p.getClientePedido().equals(c))
         .mapToDouble(p -> p.getCestaCompra().stream()
            .mapToDouble(lp -> lp.getUnidades() * articulos.get(lp.getIdArticulo()).getPvp()).sum())
         .sum();
       


      /*  return pedidos.stream()
                .filter(p -> p.getClientePedido().equals(c))
                .mapToDouble(p -> p.getCestaCompra().stream())
                .mapToDouble(lp -> lp.getUnidades() * articulos.get(lp.getIdArticulo())
                        .getPvp().sum()).sum();
       */
    }
    
   
    public void clientesTxtBackup() {
        try(BufferedWriter bfwClientes=new BufferedWriter(new FileWriter("clientes.txt"))){
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
        try(Scanner scClientes=new Scanner(new File("clientes.txt"))){
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
    
    public void eliminarArchivo() {  

	Scanner sc = new Scanner(System.in);  

	System.out.println("Indica el nombre del archivo a borrar: ");  

	String nombre = sc.nextLine();  

        File f = new File(nombre); 	 

        System.out.println(f.getAbsolutePath());  

	if(f.delete()){  

		System.out.println("El archivo ha sido eliminado");  

	} else{  

		System.out.println("No se ha podido eliminar :(");  

	} 

    } 
    public void cambioNombre() { 

        Scanner sc = new Scanner(System.in); 

	System.out.println("Indica el nombre del archivo a renombrar: "); 

        String nombre = sc.nextLine();  

        File f1 = new File(nombre);  

	System.out.println("Indica el nuevo nombre del archivo ");  

	String nombre2 = sc.nextLine();  

	File f2 = new File(nombre2);  

	if(f1.renameTo(f2)){  

		System.out.println("El nombre del archivo se ha cambiado con éxito =)");  

	} else{  

		System.out.println("No se ha podido cambiar el nombre del archivo :(");  

	}  

    } 
    public void listadoContenido() { 

        Scanner sc = new Scanner(System.in);  

        File carpeta;  

        System.out.println("Nombre de la carpeta a LISTAR -(ENTER) para mostrar contenido de la carpeta ACTUAL: ");  

        String nombre = sc.nextLine();  

        if (nombre==""){  

                carpeta= new File("."); 

        }else{  

            carpeta= new File(nombre); 

        }  

        String[] listado = carpeta.list();  

        for (String s: listado) {  

            System.out.println(s);  

        }  

    } 
    public void informacionArchivo() { 

        File f= new File("clientes.dat");  //cualquier archivo

        try {  
            f.createNewFile();  

        } catch (IOException e) {  

            System.out.println(e.getMessage());  

        } System.out.println("Nombre: " + f.getName());  

        System.out.println("Ruta: " + f.getAbsolutePath() );  

        System.out.println("Tamaño en Bytes: " + f.length() );  

        System.out.println("Fecha Última modificación: " + new Date (f.lastModified()));  

    } 
    
   //ESCRITURA en un archivo de texto(añadiendo líneas a las ya existentes) 
   public void escritura(){
  
    Scanner sc=new Scanner(System.in); 
   
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("fichero.txt", true))) { 
    
        String cadena;
        System.out.println("Teclea líneas de texto + RETORNO - (FIN para terminar)");
        cadena = sc.nextLine();
        while (!cadena.equalsIgnoreCase("FIN")) {
            bw.write(cadena); //escribe la cadena en el BufferedWriter 
            bw.newLine(); //añade un salto de línea 
            cadena = sc.nextLine();  } //Solicita una nueva cadena
    } catch (IOException e) { 
        System.out.println("No se ha podido escribir en el fichero"); 
      }  
  }
   ////LECTURA línea a línea desde un archivo de texto (Se imprime en pantalla)
   public void lecturaLineaPorLinea(){
 
    try (BufferedReader br = new BufferedReader(new FileReader("clientes.txt"))) { 
        String cadena = br.readLine();  // lee la primera línea del fichero 
        while (cadena != null) {    // mientras no se llegue al final del archivo 
            System.out.println(cadena);     // se nuestra por pantalla 
            cadena = br.readLine();     // se lee la siguiente línea del archivo 
        }
    }catch (FileNotFoundException e) { 
    System.out.println(e.getMessage()); 
    }catch (IOException e) { 
    System.out.println(e.getMessage()); }  
}
   //LECTURA carácter a carácter desde un archivo de texto (Se imprime en pantalla)
   public void lecturaCaracterPorCaracter(){
       
        try (BufferedReader br = new BufferedReader(new FileReader("clientes.txt"))) { 
            int caracter = br.read();   //se lee el primer carácter del fichero 
        while (caracter != -1) {    //mientras no se llegue al final del archivo EOF = -1 
            System.out.print((char)caracter);  //se nuestra por pantalla
            caracter = br.read();   //se lee el siguiente carácter del archivo 
        }
    }catch (FileNotFoundException e) { 
    System.out.println(e.getMessage()); 
    }catch (IOException e) { 
    System.out.println(e.getMessage()); } 
}
    
    
    
    public void restaurarPedidosDeCliente() {
    System.out.print("Ingrese el DNI del cliente cuyos pedidos quiere restaurar: ");
    String dni = sc.nextLine();

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("pedidos.dat"))) {
        Pedido p;
        while ((p = (Pedido) ois.readObject()) != null) {
            if (p.getClientePedido().getDni().equals(dni)) {
                pedidos.add(p);
            }
        }
        System.out.println("Pedidos de " + dni + " restaurados correctamente.");
    } catch (EOFException e) {
        System.out.println("Fin del archivo alcanzado.");
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Error al restaurar pedidos: " + e.getMessage());
    }
}
    
    public void backupClientesConPedidos() {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("clientesPedidos.dat"))) {
        HashMap<String, Cliente> clientesConPedidos = new HashMap<>();
        
        for (Pedido p : pedidos) {
            clientesConPedidos.put(p.getClientePedido().getDni(), p.getClientePedido());
        }

        for (Cliente c : clientesConPedidos.values()) {
            oos.writeObject(c);
        }

        System.out.println("Backup de clientes con pedidos realizado con éxito.");
    } catch (IOException e) {
        System.out.println("Error al guardar backup: " + e.getMessage());
    }
}
    
    public void backupCompleto() {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("backupCompleto.dat"))) {
        oos.writeObject(clientes);
        oos.writeObject(articulos);
        oos.writeObject(pedidos);
        System.out.println("Backup completo realizado en backupCompleto.dat");
    } catch (IOException e) {
        System.out.println("Error al realizar backup: " + e.getMessage());
    }
}
    
    public void restaurarDesdeBackupCompleto() {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("backupCompleto.dat"))) {
        clientes = (HashMap<String, Cliente>) ois.readObject();
        articulos = (HashMap<String, Articulo>) ois.readObject();
        pedidos = (ArrayList<Pedido>) ois.readObject();
        System.out.println("Datos restaurados desde backupCompleto.dat.");
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Error al restaurar backup: " + e.getMessage());
    }
}
    
    //IMPORTANTE 
    public void generarInformeVentasMensuales() {
    HashMap<Integer, Double> ventasPorMes = new HashMap<>();

    for (Pedido p : pedidos) {
        int mes = p.getFechaPedido().getMonthValue();
        ventasPorMes.put(mes, ventasPorMes.getOrDefault(mes, 0.0) + totalPedido(p));
    }

    try (BufferedWriter bw = new BufferedWriter(new FileWriter("ventasMensuales.txt"))) {
        bw.write("Mes\tTotal Ventas\n");
        for (int mes : ventasPorMes.keySet()) {
            bw.write(mes + "\t" + ventasPorMes.get(mes) + "\n");
        }
        System.out.println("Informe de ventas generado en ventasMensuales.txt.");
    } catch (IOException e) {
        System.out.println("Error al generar informe: " + e.getMessage());
    }
}
    
    public void restaurarPedidosCaros() {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("pedidos.dat"))) {
        Pedido p;
        while ((p = (Pedido) ois.readObject()) != null) {
            if (totalPedido(p) > 1000) {
                pedidos.add(p);
            }
        }
        System.out.println("hola mundo");
    } catch (EOFException e) {
        System.out.println("Fin del archivo alcanzado.");
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Error al restaurar pedidos: " + e.getMessage());
    }
}
    
    
    
    //<editor-fold defaultstate="collapsed" desc="Metodos Que Ya USAMOS">
    
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
    
//</editor-fold>
   
  
//<editor-fold defaultstate="collapsed" desc="STREAMS">
   

// 1. PERSISTENCIA
public void guardarPedidosPorCliente() {
    for (Cliente cliente : clientes.values()) {
        List<Pedido> pedidosCliente = pedidos.stream()
                .filter(p -> p.getClientePedido().equals(cliente))
                .toList();

        if (!pedidosCliente.isEmpty()) {
            String nombreArchivo = cliente.getNombre() + ".txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
                for (Pedido pedido : pedidosCliente) {
                    writer.write(pedido.getIdPedido() + "," + cliente.getNombre() + "," + pedido.getFechaPedido());
                    writer.newLine();
                }
            } catch (IOException e) {
                System.out.println("Error al guardar pedidos para " + cliente.getNombre() + ": " + e.getMessage());
            }
        }
    }
}

// 2. Streams
public int calcularNumeroPedidosCliente(Cliente cliente) {
    return (int) pedidos.stream()
            .filter(p -> p.getClientePedido().equals(cliente))
            .count();
}
public int calcularNumeroArticulosPedido(Pedido pedido) {
        return pedido.getCestaCompra().stream()
                .mapToInt(LineaPedido::getUnidades)
                .sum();
    }

// 3. Sorted
public void listadoClientes() {
    clientes.values().stream()
            .sorted(Comparator.comparing(Cliente::getDni))
            .forEach(c -> System.out.println(c.getDni() + ", " + c.getNombre() + ", " + calcularNumeroPedidosCliente(c)));
}

public void listadoPedidosPorArticulos() {
    pedidos.stream()
            .filter(p -> calcularNumeroArticulosPedido(p) >= 2)
            .sorted(Comparator.comparing(this::calcularNumeroArticulosPedido).reversed())
            .forEach(p -> System.out.println(p.getIdPedido() + ", " + p.getClientePedido().getNombre() + ", " + calcularNumeroArticulosPedido(p)));
}

public void listadoPedidosUltimos15Dias() {
    LocalDate hace15Dias = LocalDate.now().minusDays(15);
    pedidos.stream()
            .filter(p -> p.getFechaPedido().isAfter(hace15Dias))
            .sorted(Comparator.comparing(Pedido::getFechaPedido).reversed())
            .forEach(p -> System.out.println(p.getIdPedido() + ", " + p.getFechaPedido() + ", " + p.getClientePedido().getNombre()));
}

// 4. Collect
public void crearColeccionesArticulos() {
    List<Articulo> lista = articulos.values().stream()
            .filter(a -> a.getIdArticulo().startsWith("2"))
            .sorted(Comparator.comparing(Articulo::getPvp))
            .toList();

    Set<Articulo> conjunto = articulos.values().stream()
            .filter(a -> a.getPvp() > 100)
            .collect(Collectors.toSet());

    Map<String, Articulo> mapa = articulos.values().stream()
            .filter(a -> a.getExistencias() < 5)
            .collect(Collectors.toMap(Articulo::getIdArticulo, a -> a));

    System.out.println("Lista:");
    lista.forEach(System.out::println);

    System.out.println("Conjunto:");
    conjunto.forEach(System.out::println);

    System.out.println("Mapa:");
    mapa.forEach((id, articulo) -> System.out.println(id + ": " + articulo));
}
  
//</editor-fold>
   

}
