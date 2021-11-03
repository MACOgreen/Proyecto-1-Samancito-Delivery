/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roles;

import ClasesGrafo.Grafo;
import ClasesGrafo.Lista;
import ClasesGrafo.Nodos;
import Lectura.ListDatos;
import Lectura.NodoArreglo;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Driver {
    int[] resultado;
    Grafo  g;
    private String[][] matriz;
    private int[][] matriz2;
    private String[][] matriz3;
    String m;
    ListDatos pedidos;
    NodoArreglo nodo;
    Nodos aux;
    
    int origen;
    int destino;
    int numeroOrden;

    public Driver(Grafo g, ListDatos pedidos) {
        this.g = g;
        this.pedidos = pedidos;
    }
    
    public String mostrarPedidos(){
        String resultado="";
        nodo=pedidos.getFirst();
        System.out.println("Pedidos:  ");
       
        while(nodo!=null){
            System.out.println("Numero de orden: "+ nodo.getNumOrden() + " ,Orden: " + nodo.getNumber()[2]+", Nodo destino: "+nodo.getNumber()[0] );
            resultado+=" Numero de orden: "+ nodo.getNumOrden() + " ,Orden: " + nodo.getNumber()[2]+", Nodo destino: "+nodo.getNumber()[0]+"----";
            nodo=nodo.getNext();
        }
        
        return resultado;
    }
    
    public void copiarMatriz(){
        matriz=g.getMatrizAD();
        matriz2=new int[g.getLnodos().getSize()][g.getLnodos().getSize()];
        matriz3=new String[g.getLnodos().getSize()][g.getLnodos().getSize()];
        for(int i=0; i<g.getLnodos().getSize();i++){
            for(int j=0; j<g.getLnodos().getSize();j++){
                if(matriz[i][j].equals("0")){
                    matriz3[i][j]="99999";
                    matriz2[i][j]=99999;
                }
                else{
                    matriz2[i][j]=Integer.parseInt(matriz[i][j]);
                    matriz3[i][j]=matriz[i][j];
                }
            }
        }
    }
    
    
    public void RutaMcortaDijkstra(){
        
        
        
        copiarMatriz();
        int[] etiqueta= new int[2];
        int posicion=0;       /////Para eliminar de la lista
        
        
        nodo=pedidos.getFirst();
        
        //El usuario seleciona el numero de orden
        
        
        numeroOrden=Integer.parseInt(JOptionPane.showInputDialog("Seleciona el numero de pedido que quiere entregar "));
        
        //
        
        //Proceso para identifcar nodo origen y destino
        String ori=" ";
        String desti=" ";
        while(nodo!=null){
            if(nodo.getNumOrden()==numeroOrden){
                ori=nodo.getNumber()[1];
                desti=nodo.getNumber()[0];
                break;
            }
            posicion++;
            nodo=nodo.getNext();
        }
         pedidos.Eliminar(posicion); /// elimina pedido. 
         origen=g.getLnodos().posicion(ori);
         
         destino=g.getLnodos().posicion(desti);
        //
        //Empiezo a recorrer la matriz de adyacencia ( Empieza Dijkstra)
        
       
        resultado= new int[g.getLnodos().getSize()];
        resultado[0]=origen;
        
        int path_array[] = new int[matriz2[0].length];
        Boolean sptSet[] = new Boolean[matriz2[0].length];
        for (int i = 0; i <matriz2[0].length ; i++) { 
            path_array[i] = Integer.MAX_VALUE; 
            sptSet[i] = false; 
        } 
        path_array[origen] = 0;
        
        for (int count = 0; count < matriz2[0].length - 1; count++) { 
            // call minDistance method to find the vertex with min distance
            int u = minDistance(path_array, sptSet); 
              // the current vertex u is processed
            sptSet[u] = true; 
        for (int v = 0; v < matriz2[0].length; v++) 
   
                // if vertex v not in sptset then update it  
                if (!sptSet[v] && matriz2[u][v] != 0 && path_array[u] != 
                            Integer.MAX_VALUE && path_array[u] 
                            + matriz2[u][v] < path_array[v]) 
                            path_array[v] = path_array[u] + matriz2[u][v]; 
        } 
        
    
        
        System.out.println("La ruta más corta es de: "+ path_array[destino] +" kilometros.");
        JOptionPane.showMessageDialog(null,"La ruta más corta es de: "+ path_array[destino] +" kilometros." );
        
        
    }  
    
    public void rutaMcortaFloydM(){
        copiarMatriz();
        int[] rutaMorta=new int[g.getLnodos().getSize()];;
        nodo=pedidos.getFirst();
        resultado=new int[g.getLnodos().getSize()];
        int[] rutas=new int[g.getLnodos().getSize()];
        int contador=0;
        int distancia=0;
        //El usuario seleciona el numero de orden
        numeroOrden=Integer.parseInt(JOptionPane.showInputDialog("Seleciona el numero de pedido que quiere entregar "));
        //
        
        //Proceso para identifcar nodo origen y destino
        int posicion=0;       /////Para eliminar de la lista
        String ori=" ";
        String desti=" ";
        while(nodo!=null){
            if(nodo.getNumOrden()==numeroOrden){
                ori=nodo.getNumber()[1];
                desti=nodo.getNumber()[0];
                break;
            }
            posicion++;
            nodo=nodo.getNext();
        }
         pedidos.Eliminar(posicion); /// elimina pedido. 
         origen=g.getLnodos().posicion(ori);
         
         destino=g.getLnodos().posicion(desti);
         
        //
        
        
        ///Floyd-Marshall
            for(int k=0; k<g.getLnodos().getSize();k++){
                for(int i=0;i<g.getLnodos().getSize();i++){
                    for(int j=0;j<g.getLnodos().getSize();j++){
                        if(Integer.parseInt(matriz3[i][j])> Integer.parseInt(matriz3[i][k])+ Integer.parseInt(matriz3[k][j])){
                            matriz3[i][j]=Integer.toString(Integer.parseInt(matriz3[i][k])+ Integer.parseInt(matriz3[k][j]));      
                       }
                    } 
                }
            }
        ////////////////////
          
        /*
        System.out.print("[ ");
        for(int z=0;z<resultado.length;z++){
            if(resultado[i]==50){
                System.out.println(g.getLnodos().Obtener(destino).getInformacion()[0]+ " ]");
                break;
            }
            System.out.print(g.getLnodos().Obtener(resultado[i]).getInformacion()[0]+"---> " );
        }
        
        */
        
        
        //Imprimir matriz  rutas cortas
        
        for(int i=0; i<g.getLnodos().getSize();i++){
            System.out.println(Arrays.toString(matriz3[i]));
        }
        
        
        System.out.println("La ruta más corta es de: "+ matriz3[origen][destino] +" kilometros.");
        JOptionPane.showMessageDialog(null,"La ruta más corta es de: "+ matriz3[origen][destino] +" kilometros." );
        
    }
    
    public int minDistance(int path_array[], Boolean sptSet[])   { 
        // Initialize min value 
        int min = Integer.MAX_VALUE, min_index = -1; 
        for (int v = 0; v < matriz2[0].length; v++) 
            if (sptSet[v] == false && path_array[v] <= min) { 
                min = path_array[v]; 
                min_index = v; 
            } 
   
        return min_index; 
    } 
    
    
}
