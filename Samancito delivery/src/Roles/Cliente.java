package Roles;

import ClasesGrafo.Grafo;
import java.util.Scanner;
import ClasesGrafo.Lista;
import ClasesGrafo.Nodos;

public class Cliente {

    Lista a;
    Grafo g;

    public Cliente(Lista a, Grafo g) {
        this.a = a;
        this.g = g;
    }
    

    public void recorrerLista() {
        a.printlista();
        Nodos last = a.getLast();
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
            
            a.addAtTheEnd(n, arr);
            aux = a.getFirst();
            
            while (aux!= null) {
                b.addAtTheEnd(aux.getTipo(), aux.getInformacion());
                aux = aux.getNext();
            }
           
          
            
            g.Actualizar(a);
            
            a.printNodos();
            
            System.out.println ("Indique un nodo: ");
            String nodo1 = "";
            Scanner entEscaner = new Scanner (System.in); 
            nodo1 = entEscaner.nextLine ();
            System.out.println("");
            System.out.println ("Indique la distancia: ");
            String distancia1 = "";
            Scanner entscaner = new Scanner (System.in); 
            distancia1 = entscaner.nextLine ();
            
            String[] ruta1 = new String[3];
            ruta1[0] = Integer.toString(numero);
            ruta1[1] = nodo1;
            ruta1[2] = distancia1;
            
            g.rellenarFila(ruta1);
            
            System.out.println ("Indique un nodo: ");
            String nodo2 = "";
            Scanner enEscaner = new Scanner (System.in); 
            nodo2 = enEscaner.nextLine ();
            System.out.println("");
            System.out.println ("Indique la distancia: ");
            String distancia2 = "";
            Scanner entsaner = new Scanner (System.in); 
            distancia2 = entsaner.nextLine ();
            
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
 /*
        } else {
            System.out.println("Indique el numero correspondiente a sus datos");
            String numero_id = "";
            Scanner entraEscaner = new Scanner(System.in); //Creación de un objeto Scanner
            numero_id = entraEscaner.nextLine();
            while (temp != null) {
                if (temp.getTipo() == "Cliente") {
                    if (numero_id.equals(temp.getInformacion()[0])) {
                        System.out.println("Usuario encontrado con exito");
                    } else {
                        System.out.println("Numero no encontrado, registrese");
                    }
                }
                temp = temp.getNext();

            }
        }
             */
        }
    }

}
