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

        Scanner entradaEscaner = new Scanner(System.in); //Creación de un objeto Scanner

        opcion = entradaEscaner.nextLine();

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
        letra = entradEscaner.nextLine();
        System.out.println("Indique el nombre del local");
        String nombre = "";
        Scanner entraEscaner = new Scanner(System.in);
        nombre = entraEscaner.nextLine();
        
        int i = 0;
        int n = 1;
        String[] platos = new String[2];
        while (n == 1) {
            System.out.println("MENU");
            System.out.println("Escriba el plato que desea agregar: ");
            String seleccion = "";
            Scanner scaner = new Scanner(System.in); //Creación de un objeto Scanner
            seleccion = scaner.nextLine();

            platos[i] = seleccion;

            System.out.println("Indique con una A si desea agregar otro plato B para terminar menu");

            Scanner entradaner = new Scanner(System.in); //Creación de un objeto Scanner
            String o = "";
            o = entradaner.nextLine();
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
        arr[2] = Arrays.toString(platos);

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
        Scanner entEscaner = new Scanner(System.in);
        nodo1 = entEscaner.nextLine();
        System.out.println("");
        System.out.println("Indique la distancia: ");
        String distancia1 = "";
        Scanner entscaner = new Scanner(System.in);
        distancia1 = entscaner.nextLine();

        String[] ruta1 = new String[3];
        ruta1[0] = letra;
        ruta1[1] = nodo1;
        ruta1[2] = distancia1;

        g.rellenarFila(ruta1);

        System.out.println("Indique un nodo: ");
        String nodo2 = "";
        Scanner enEscaner = new Scanner(System.in);
        nodo2 = enEscaner.nextLine();
        System.out.println("");
        System.out.println("Indique la distancia: ");
        String distancia2 = "";
        Scanner entsaner = new Scanner(System.in);
        distancia2 = entsaner.nextLine();

        String[] ruta2 = new String[3];
        ruta2[0] = letra;
        ruta2[1] = nodo2;
        ruta2[2] = distancia2;

        g.rellenarFila(ruta2);

        g.CrearMatrizAD();
        g.ImprimirMatriz();
        
        a.printrestaurantes();
        
    }
}
