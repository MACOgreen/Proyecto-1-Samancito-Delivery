/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samancito.delivery;

import Clases.Grafo;
import Clases.Lista;
import Clases.Nodos;
import java.util.Arrays;

/**
 *
 * @author mani
 */
public class SamancitoDelivery {

    static Lista l= new Lista();
    static String tipo;
    static Grafo grafo;
    
    
    public static void main(String[] args) {
        
        tipo="Restaurante";
        String[] informacion = {"A","Pizpa","Pizza", "Margarita","Pasticho","Refresco"};
        l.addAtTheEnd(tipo, informacion);
        
        tipo="Restaurante";
        String[] informacion2={"B","Sótano Siete","Prosciutto Funghi","Pizza Napoletana","Calzone"};
        l.addAtTheEnd(tipo, informacion2);
        
        tipo="Cliente";
        String[] informacion3={"1","Pepe","Gónzales","234354"};
        l.addAtTheEnd(tipo, informacion3);
        
        
        
        grafo=new Grafo(l);
        
        String[] ruta1={"A","1","3"};
        grafo.rellenarFila(ruta1);
        
       
        
        
        String[] ruta2={"B","1","5"};
        grafo.rellenarFila(ruta2);
        
        
        String[] ruta3={"A","B","2"};
        grafo.rellenarFila(ruta3);
        
        
        grafo.Imprimirfila();
        
        
        
        //Arreglar lo del arreglo de distancias que es el mismo para todos los nodos.
        
    }
    
}

