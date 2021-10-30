/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesGrafo;

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
     * 
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
    /**
     * Description: se elige un vértice no visitado v, como punto de partida y se pasa a visitar cada uno de sus vértices 
     * adyacentes, para continuar posteriormente visitando los adyacentes a estos últimos y así sucesivamente hasta que no 
     * se puedan alcanzar más vértices.
     * @param g 
     */
    public void amplitud(Grafo g){
        Cola cola= new Cola();
        boolean visitados[]= new boolean[g.getLnodos().getSize()];
         int v;
         String no;
         
         
         for(int i=0;i<g.getLnodos().getSize();i++){
             visitados[i]=false;
         }
         
         for(int i=0; i<g.getLnodos().getSize();i++){
             if(!visitados[i]){
                 cola.encolar(i);
                 visitados[i]=true;
                 
                 
                 while(!cola.es_vacia()){
                     v =cola.desencolar();
                     no=g.getLnodos().Obtener(v).getInformacion()[0];
                     System.out.println(no);
                     
                     
                     for(int j=0;j<g.getLnodos().getSize();j++){
                         if((v!=j)&&(g.existeArista(v, j)&&(!visitados[j]) )){
                             cola.encolar(j);
                             visitados[j]=true;
                         }
                     }
                 }
             }
         }
    }
    
    
    
    
    
}
