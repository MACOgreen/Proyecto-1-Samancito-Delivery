/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Arrays;

/**
 *
 * @author mani
 */

public class Grafo {
    int numVertices;
    Lista matrizAD ;
    int maxNodos;
    Nodos aux;
    String [] arreglo;

    public Grafo(Lista matrizADYA,String[] distancias) {
        
        this.matrizAD=matrizADYA;
        aux=matrizAD.getFirst();
        this.arreglo=distancias;
        
        
        while(aux!=null){
            aux.setDistancias(arreglo);
            aux=aux.getNext();     
        }
        
    }
    
    public void rellenarFila(String[] rutas){
        String identificador= rutas[0];
        aux=matrizAD.getFirst();
        
        while(aux!=null){
            
            if(identificador.equals(aux.getInformacion()[0])){
                Nodos aux2=matrizAD.getFirst();
                int indice=0;
                
                while(aux2!=null){
                    if(rutas[1].equals(aux2.getInformacion()[0])){
                        aux.getDistancias()[indice]=rutas[2];
                        
                    }
                    
                    aux2=aux2.getNext();
                    indice++;
                }           
            }
            aux=aux.getNext();  
        }
        
        
            
    }
    public void Imprimirfila(){
        aux=matrizAD.getFirst();
        
        while(aux!=null){
            System.out.println(Arrays.toString(aux.getDistancias()));
            
            aux=aux.getNext();
        }
        
    }
    
    
    
}
