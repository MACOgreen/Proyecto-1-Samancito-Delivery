/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author mani
 */
public  class   Recorridos {
    
    
    
    public   void recorrerProfundidad(Grafo g,int v, boolean [] visitados){
        visitados[v]=true;
        
        System.out.println(g.getLnodos().Obtener(v).getInformacion()[0]);
        
        for(int i=0;i<g.getLnodos().getSize();i++){
            if ((v != i) && (!visitados [i]) && (g.existeArista (v, i)) ){
                recorrerProfundidad (g, i, visitados);
            }
        }
        
    }
    /**
     * Description: Procedimiento que recorre el grafo por recorrido de profundidad. Va visitando un nodo uno por uno. 
     * @param g   " Grafo que quiero recorrer "
     * @author: Manuel Caceres
     */
    public  void profundidad(Grafo g){
        
        boolean visitados[]= new boolean [g.getLnodos().getSize()];
        for (int i = 0; i < g.getLnodos().getSize(); i++){
            visitados [i] = false;
        }
        
        
        
        for (int i = 0; i < g.getLnodos().getSize(); i++){
            if (!visitados [i]){
                recorrerProfundidad (g, i, visitados);
            }
        }
        
    }
    
    
    
    
    
}
