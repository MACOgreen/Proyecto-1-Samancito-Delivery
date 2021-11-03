package Roles;

import ClasesGrafo.Grafo;
import java.util.Scanner;
import ClasesGrafo.Lista;
import ClasesGrafo.Nodos;
import Lectura.ListDatos;
import java.util.Arrays;

public class Cliente {

    Lista a;
    Grafo g;
    ListDatos pedidos;

    public Cliente(Lista a, Grafo g, ListDatos pedidos) {
        this.a = a;
        this.g = g;
        this.pedidos = pedidos;
    }

    public void nuevo_pedido(ListDatos pedidos, String numero_id, String letra_id, Lista platos_total) {
        //
        
        //pedidos.addAtTheEnd(pedido_final);
        
    }

    public void recorrerLista() {
        a.printclientes();
        Nodos last = a.getLast();
        Nodos temp = a.getFirst();
        Nodos l = a.getFirst();
        Nodos aux;
        Lista b = new Lista();

        System.out.println("Indique con una A si es un nuevo usuario o con una B si esta registrado");

        String opcion = "";

        Scanner entradaEscaner = new Scanner(System.in); //Creación de un objeto Scanner

        opcion = entradaEscaner.nextLine();
        System.out.println(opcion);

        if ("A".equals(opcion)) {
            System.out.println("Indique su nombre");
            String nombre = "";
            Scanner entradEscaner = new Scanner(System.in);
            nombre = entradEscaner.nextLine();
            System.out.println("Indique su apellido");
            String apellido = "";
            Scanner entraEscaner = new Scanner(System.in);
            apellido = entraEscaner.nextLine();
            System.out.println("Indique su cedula");
            String cedula = "";
            Scanner entrEscaner = new Scanner(System.in);
            cedula = entrEscaner.nextLine();

            String[] arr = new String[4];
            String tipo = "Cliente";
            String n = null;

            if (last.getTipo() == "Cliente") {
                n = last.getInformacion()[0];
            }

            int numEntero = Integer.parseInt(n);
            int numero = numEntero + 1;
            arr[0] = Integer.toString(numero);
            arr[1] = nombre;
            arr[2] = apellido;
            arr[3] = cedula;

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
            ruta1[0] = Integer.toString(numero);
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
            ruta2[0] = Integer.toString(numero);
            ruta2[1] = nodo2;
            ruta2[2] = distancia2;

            g.rellenarFila(ruta2);

            g.CrearMatrizAD();
            g.ImprimirMatriz();

            //arr[4] = direccion;
            /*
            addAtTheEnd(tipo, arr);
            last = last.setNext();
            if ("Cliente".equals(last.getTipo())) {
                System.out.println(last.getInformacion()[0] + " ------> " + last.getInformacion()[1] + " " + last.getInformacion()[2]);
                System.out.println("Usuario registrado con exito");
            }
            recorrerLista();

            /*
        System.out.println ("Por favor introduzca el numero correspondiente a sus datos:");

        String entradaTeclado = "";

        //Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner

        entradaTeclado = entradaEscaner.nextLine ();
             */
        } else {
            System.out.println("Indique el numero correspondiente a sus datos");
            String numero_id = "";
            Scanner entraEscaner = new Scanner(System.in); //Creación de un objeto Scanner
            numero_id = entraEscaner.nextLine();
            Boolean e = false;
            while (temp != null) {
                if ("Cliente".equals(temp.getTipo())) {
                    if (numero_id.equals(temp.getInformacion()[0])) {
                        e = true;
                        break;
                    } else {
                        e = false;

                    }
                }
                temp = temp.getNext();

            }

            if (e = true) {
                System.out.println("Usuario encontrado con exito");
                System.out.println("\n");
                System.out.println("Bienvenido");

                System.out.println(temp.getInformacion()[0] + " ------> " + temp.getInformacion()[1] + " " + temp.getInformacion()[2]);
                System.out.println("Cedula " + temp.getInformacion()[3]);

                System.out.println("\n");
                System.out.println("Realizar orden");
                System.out.println("\n");
                System.out.println("Lista de restaurantes");
                a.printrestaurantes();

                System.out.println("Indique la letra del restaurante que quiere seleccionar");

                String letra_id = "";

                Scanner enEscaner = new Scanner(System.in); //Creación de un objeto Scanner

                letra_id = enEscaner.nextLine();

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

                    int n = 1;
                    Lista platos_total = new Lista();
                    while (n == 1) {

                        System.out.println("Indique el numero del plato que desea seleccionar");
                        String seleccion = "";
                        Scanner scaner = new Scanner(System.in); //Creación de un objeto Scanner
                        seleccion = scaner.nextLine();

                        System.out.println("Indique la cantidad que desea pedir");
                        String seleccion2 = "";
                        Scanner caner = new Scanner(System.in); //Creación de un objeto Scanner
                        seleccion2 = caner.nextLine();

                        String[] platos = new String[2];
                        platos[0] = seleccion2;
                        platos[1] = l.getInformacion()[2].split("/")[Integer.parseInt(seleccion) - 1];
                        
                        platos_total.addAtTheEnd("Pedido", platos);

                        System.out.println("Indique con una A si desea agregar otro plato B para terminar pedido");

                        Scanner entradaner = new Scanner(System.in); //Creación de un objeto Scanner
                        String o = "";
                        o = entradaner.nextLine();
                        System.out.println(o);

                        if (o.equals("A")) {
                            n = 1;
                        } else {
                            n = 0;
                        }

                    }
                    
                    nuevo_pedido(pedidos, numero_id, letra_id, platos_total);
                    
                    

                } else {
                    System.out.println("Numero no encontrado, registrese");
                    recorrerLista();
                }

            }

        }
    }

}
