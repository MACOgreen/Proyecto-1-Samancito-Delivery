/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roles;

import ClasesGrafo.Grafo;
import ClasesGrafo.Lista;
import ClasesGrafo.Nodos;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author aleja
 */
public class Administrador {

    Lista a;
    Grafo g;

    public Administrador(Lista a, Grafo g) {
        this.a = a;
        this.g = g;
    }

    public void inicio_administrador() {
        System.out.println("Bienvenido a Samancito Delivery");
        System.out.println("\n");
        System.out.println("Opciones de Administrador");
        System.out.println("1. Agregar nuevos locales");
        System.out.println("2. Agregar nuevo camino");
        System.out.println("3. Agregar platos");
        System.out.println("4. Eliminar platos");
        System.out.println("\n");
        System.out.println("Indique la opcion que desea realizar");

        String opcion = "";

        

        

        if ("1".equals(opcion)) {
            agregar_locales();
        }
    }

    public void agregar_locales() {
        Nodos last = a.getLast();
        Nodos temp = a.getFirst();
        Nodos l = a.getFirst();
        Nodos aux;
        Lista b = new Lista();

        a.printrestaurantes();

        System.out.println("Indique la letra para identificar el local: ");
        String letra = "";
        Scanner entradEscaner = new Scanner(System.in);
        letra =JOptionPane.showInputDialog("Indique la letra para identificar el local:");
        System.out.println("Indique el nombre del local");
        String nombre = "";
        
        nombre = JOptionPane.showInputDialog("Indique el nombre del local");
        
        int i = 0;
        int n = 1;
        String platos_menu = "";
        while (n == 1) {
            System.out.println("MENU");
            System.out.println("Escriba el plato que desea agregar: ");
            String seleccion = "";
            
            seleccion = JOptionPane.showInputDialog("Escriba el plato que desea agregar: ");

            if (platos_menu == "") {
                platos_menu = seleccion;
            } else {
                platos_menu = platos_menu + "/" + seleccion;
            }

            System.out.println("Indique con una A si desea agregar otro plato B para terminar menu");

            Scanner entradaner = new Scanner(System.in); //Creación de un objeto Scanner
            String o = "";
            o = JOptionPane.showInputDialog("Indique con una A si desea agregar otro plato o  B para terminar menu");
            System.out.println(o);

            if (o.equals("A")) {
                n = 1;
                i ++;
            } else {
                n = 0;
            }

        }
        
        
        

        String[] arr = new String[3];
        String tipo = "Restaurante";
        
        arr[0] = letra;
        arr[1] = nombre;
        arr[2] = platos_menu;

        a.addAtTheEnd(tipo, arr);
        aux = a.getFirst();

        while (aux != null) {
            b.addAtTheEnd(aux.getTipo(), aux.getInformacion());
            aux = aux.getNext();
        }

        g.Actualizar(a);

        a.printNodos();

        System.out.println("Indique un nodo: ");
        String nodo1 = "";
        
        nodo1 = JOptionPane.showInputDialog("Indique un nodo");
        System.out.println("");
        System.out.println("Indique la distancia: ");
        String distancia1 = "";
        
        distancia1 = JOptionPane.showInputDialog("Indique la distancia");

        String[] ruta1 = new String[3];
        ruta1[0] = letra;
        ruta1[1] = nodo1;
        ruta1[2] = distancia1;

        g.rellenarFila(ruta1);

        System.out.println("Indique un nodo: ");
        String nodo2 = "";
       
        nodo2 = JOptionPane.showInputDialog("Indique un nodo");
        System.out.println("");
        System.out.println("Indique la distancia: ");
        String distancia2 = "";
        
        distancia2 = JOptionPane.showInputDialog("Indique la distancia");

        String[] ruta2 = new String[3];
        ruta2[0] = letra;
        ruta2[1] = nodo2;
        ruta2[2] = distancia2;

        g.rellenarFila(ruta2);

        g.CrearMatrizAD();
        g.ImprimirMatriz();
        
        a.printrestaurantes();
       
        
    }
    public void agregar_ruta() {
        a.printNodos();

        System.out.println("Indique la letra/numero para identificar la ruta: ");
        String letra = "";
        
        letra = JOptionPane.showInputDialog("Indique la letra/numero para identificar la ruta: ");

        System.out.println("Indique un nodo: ");
        String nodo1 = "";
        
        nodo1 = JOptionPane.showInputDialog("Indique un nodo");
        System.out.println("");
        System.out.println("Indique la distancia: ");
        String distancia1 = "";
        
        distancia1 = JOptionPane.showInputDialog("Indique ua distancia");

        String[] ruta1 = new String[3];
        ruta1[0] = letra;
        ruta1[1] = nodo1;
        ruta1[2] = distancia1;

        g.rellenarFila(ruta1);

        System.out.println("Indique un nodo: ");
        String nodo2 = "";
        
        nodo2 = JOptionPane.showInputDialog("Indique un nodo");
        System.out.println("");
        System.out.println("Indique la distancia: ");
        String distancia2 = "";
        
        distancia2 = JOptionPane.showInputDialog("Indique una distancia");

        String[] ruta2 = new String[3];
        ruta2[0] = letra;
        ruta2[1] = nodo2;
        ruta2[2] = distancia2;

        g.rellenarFila(ruta2);

        g.CrearMatrizAD();

        System.out.println("Ruta guardada con exito");
        
    }
    
    
    
     public void agregar_plato() {
        Nodos l = a.getFirst();
        System.out.println("Lista de restaurantes");
        a.printrestaurantes();

        System.out.println("Indique la letra del restaurante que quiere seleccionar");

        String letra_id = "";

        

        letra_id = JOptionPane.showInputDialog("Indique la letra del restaurante que quiere selecionar.");

        Boolean r = false;

        while (l != null) {
            if ("Restaurante".equals(l.getTipo())) {
                if (letra_id.equals(l.getInformacion()[0])) {
                    r = true;
                    break;
                } else {
                    r = false;

                }
            }
            l = l.getNext();

        }

        if (r = true) {
            System.out.println(l.getInformacion()[0] + " ------> " + l.getInformacion()[1]);

            for (int i = 0; i < l.getInformacion()[2].split("/").length; i++) {
                System.out.println((i + 1) + " ----> " + l.getInformacion()[2].split("/")[i]);
            }

            System.out.println("Indique el nombre del plato que desea agregar");
            String seleccion = "";
            
            seleccion = JOptionPane.showInputDialog("Indique el nombre del plato que desea agregar");

            String platos = l.getInformacion()[2] + "/" + seleccion;
            l.getInformacion()[2] = platos;

            System.out.println(l.getInformacion()[2]);

        }
        
    }
     
    public void eliminar_plato() {
        Nodos l = a.getFirst();
        System.out.println("Lista de restaurantes");
        a.printrestaurantes();

        System.out.println("Indique la letra del restaurante que quiere seleccionar");

        String letra_id = "";

        

        letra_id = JOptionPane.showInputDialog("Indique la letrar del restaurante que quiere selecionar");

        Boolean r = false;

        while (l != null) {
            if ("Restaurante".equals(l.getTipo())) {
                if (letra_id.equals(l.getInformacion()[0])) {
                    r = true;
                    break;
                } else {
                    r = false;

                }
            }
            l = l.getNext();

        }

        if (r = true) {
            System.out.println(l.getInformacion()[0] + " ------> " + l.getInformacion()[1]);

            for (int i = 0; i < l.getInformacion()[2].split("/").length; i++) {
                System.out.println((i + 1) + " ----> " + l.getInformacion()[2].split("/")[i]);
            }

            String platos_finales = "";
            int n = 1;
            while (n == 1) {

                System.out.println("Indique el numero del plato que desea eliminar");
                String seleccion = "";
                
                seleccion = JOptionPane.showInputDialog("Indique el numero del plato que desea eliminar");

                String platos = l.getInformacion()[2].split("/")[Integer.parseInt(seleccion) - 1];

                for (int i = 0; i < l.getInformacion()[2].split("/").length; i++) {
                    if (!l.getInformacion()[2].split("/")[i].equals(l.getInformacion()[2].split("/")[Integer.parseInt(seleccion) - 1])) {
                        if (platos_finales == "") {
                            platos_finales = l.getInformacion()[2].split("/")[i];
                        } else {
                            platos_finales = platos_finales + "/" + l.getInformacion()[2].split("/")[i];
                        }
                    }
                }

                System.out.println("Indique con una A si desea agregar otro plato B para terminar pedido");

                
                String o = "";
                o = JOptionPane.showInputDialog("Indique con una A si desea agregar otro plato o  B para terminar pedido");
                System.out.println(o);

                if (o.equals("A")) {
                    n = 1;
                } else {
                    n = 0;
                }

            }

            l.getInformacion()[2] = platos_finales;
        }
        
    }
     
     
    
    
}
