/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Arrays;

/**
 *Description: Clase utilizada para crear un grafo.
 * @author Manuel Caceres
 */

public class Grafo {
    int numVertices;
    Lista lnodos;
    int maxNodos;
    Nodos aux;
   String[][] matrizAD;
    
    /**
     * Description: Constructor de la clase grafo. Para crear un grafo se tiene que pasar una lista que contiene los nodos 
     * del grafo. Cada nodo tiene asociado una arreglo para representar las filas de la matriz de adyacencia. 
     * @param matrizADYA 
     * @author Manuel Caceres
     */
    public Grafo(Lista listaNodos) {
        
        this.lnodos=listaNodos;
        aux=lnodos.getFirst();
        
    }
    /**
     * Description: Procedimiento que me permite ubicar elementos dentro de la matriz de adyacencia. Recibe como parametro una ruta 
     * del Txt en forma de arreglo, y utiliza esa informacion para ubicar las distancias entre nodos en la matriz.
     * @param rutas 
     * @author Manuel Caceres
     */
    public void rellenarFila(String[] rutas){
        String identificador= rutas[0];
        aux=lnodos.getFirst();
        
        while(aux!=null){
            
            if(identificador.equals(aux.getInformacion()[0])){
                Nodos aux2=lnodos.getFirst();
                int indice=0;
                
                while(aux2!=null){
                    if(rutas[1].equals(aux2.getInformacion()[0])){
                        aux.getDistancias()[indice]=rutas[2];
                        
                    }
                    /*
                    if(aux.getDistancias()[indice]==null){
                        aux.getDistancias()[indice]="0";
                    }
                    */
                    
                    aux2=aux2.getNext();
                    indice++;
                }           
            }
            aux=aux.getNext();  
        }        
    }
    
    public void CrearMatrizAD(){
        this.matrizAD= new String[lnodos.getSize()][lnodos.getSize()];
        this.aux=lnodos.getFirst();
        for(int i=0;i <lnodos.getSize();i++){
            matrizAD[i]=aux.getDistancias();
            aux=aux.getNext();
        }
    
    }
    /**
     * Description: Procedimiento utilizado imprimir las filas de la matriz de adyacencia. Se recorre cada nodo del grafo y
     * se imprime su arreglo asociado. Este procedimiento se utilizo en la elaboracion de este proyecto para comprobar que el grafo 
     * funcionara bien. 
     * @author Manuel Caceres
     */
    public void ImprimirMatriz(){
        for(int i=0; i< lnodos.getSize();i++){
            System.out.println(Arrays.toString(matrizAD[i]));
        }        
    }
    
    
    
}
