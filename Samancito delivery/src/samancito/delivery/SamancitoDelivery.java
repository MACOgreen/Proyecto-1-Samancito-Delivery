
package samancito.delivery;


import ClasesGrafo.Grafo;
import ClasesGrafo.Lista;
import ClasesGrafo.Recorridos;
import Lectura.*;

import Mostrargrafo.mostrarG;
import Roles.Administrador;
import Roles.Driver;

import Roles.Cliente;



/**
 *
 * @author mani
 */
public class SamancitoDelivery {

    
    
    
    /*
    static Lista l= new Lista();
    static String tipo;
    static Grafo grafo;
    static Recorridos re= new Recorridos();
    */
    public static void main(String[] args) {
        ListDatos pedidos;
        Grafo grafo;
        //Cargar ca= new Cargar();
        mostrarG mostrar;
        Cliente clientes;
        Driver drive;
        Administrador administrador;

        
        Base_de_Datos bdatos= new Base_de_Datos();
        
        //Lista de pedidos

        pedidos=bdatos.datos();
       
        //Grafo obtenido de leer la base de datos. 
        grafo=bdatos.getGrafo();
        
        
        drive= new Driver(grafo,pedidos);
        drive.mostrarPedidos();
        //drive.RutaMcortaDijkstra();
        drive.rutaMcortaFloydM();
        //grafo.ImprimirMatriz();
       //clientes = new Cliente(grafo.getLnodos(), grafo, pedidos);
        
        //clientes.recorrerLista();
        administrador = new Administrador(grafo.getLnodos(), grafo);
        administrador.inicio_administrador();
        
        
        
        
        
        
    }
    
}

