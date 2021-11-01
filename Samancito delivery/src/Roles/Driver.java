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

public class Driver {
    int[] resultado;
    Grafo  g;
    private String[][] matriz;
    private String[][] matriz2;
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
    
    public void mostrarPedidos(){
        nodo=pedidos.getFirst();
        System.out.println("Pedidos:  ");
       
        while(nodo!=null){
            System.out.println("Numero de orden: "+ nodo.getNumOrden() + " ,Orden: " + nodo.getNumber()[2]+", Nodo destino: "+nodo.getNumber()[0] );
            nodo=nodo.getNext();
        }
        
    }
    
    public void copiarMatriz(){
        matriz=g.getMatrizAD();
        matriz2=new String[g.getLnodos().getSize()][g.getLnodos().getSize()];
        
        for(int i=0; i<g.getLnodos().getSize();i++){
            for(int j=0; j<g.getLnodos().getSize();j++){
                matriz2[i][j]=matriz[i][j];
            }
        }
    }
    
    
    public void RutaMcortaDijkstra(){
        copiarMatriz();
        int[] etiqueta= new int[2];
        
        
        
        nodo=pedidos.getFirst();
        
        //El usuario seleciona el numero de orden
        numeroOrden=1;
        //
        
        //Proceso para identifcar nodo origen y destino
        String ori=" ";
        String desti=" ";
        while(nodo!=null){
            if(nodo.getNumOrden()==numeroOrden){
                ori=nodo.getNumber()[1];
                desti=nodo.getNumber()[0];
            }
            nodo=nodo.getNext();
        }
        
         origen=g.getLnodos().posicion(ori);
         
         destino=g.getLnodos().posicion(desti);
        //
        
        //Empiezo a recorrer la matriz de adyacencia ( Empieza Dijkstra)
        int distancia=0;
        boolean ciclo= true;
        boolean visi=false;
        int contador=1;
        int contador2=0;
        int comparador=100;
        int caminos=0;
        etiqueta[0]=100;
        etiqueta[1]=origen;
        
        
        resultado= new int[g.getLnodos().getSize()];
        resultado[0]=origen;
        
        while(ciclo){
            
            for(int i=0;i< g.getLnodos().getSize();i++){
                    if(!matriz2[origen][i].equals("0")){
                        caminos++;
                        for(int j=0;j<resultado.length;j++){
                            if(resultado[j]==i){
                                visi=true;
                                break;
                            }
                            else{
                                visi=false;
                            }
                        }
                        if(!visi){
                        
                            distancia=Integer.parseInt(matriz2[origen][i]);
                            if(distancia<=comparador){
                                comparador=distancia;
                                etiqueta[0]=etiqueta[0]+distancia;
                                etiqueta[1]=i;
                                        
                            
                            }
                        }
                    }
            }   
                if(caminos>1){
                    matriz2[origen][etiqueta[1]]="0";
                    
                }
                caminos=0;
                for(int i=0;i<  resultado.length;i++){
                    if(resultado[i]==etiqueta[1]){
                        etiqueta[0]=etiqueta[0]-distancia;
                        if(i==0){
                            etiqueta[1]=resultado[0];
                            contador=0;
                            
                            break;
                        }
                        System.out.println(Arrays.toString(resultado));
                        System.out.println(etiqueta[1]);
                        
                        etiqueta[1]=resultado[i-1];
                        contador=i-1;
                        //resultado[i]=0;
                        break;
                        
                    }    
                }
                
                origen=etiqueta[1];
                comparador=100;
                resultado[contador]=origen;
                contador++;
            
                if(origen==destino){
                    ciclo=false;
                }
            
                if(contador==g.getLnodos().getSize()){
                   
                    origen=resultado[0];
                    //System.out.println(Arrays.toString(resultado));
                
                    resultado=new int[g.getLnodos().getSize()];
                    resultado[0]=origen;
                    contador=1;
                    
                
                    
                } 
            }
        
        System.out.print("[ ");
        for(int i=0;i<resultado.length;i++){
            if(resultado[i]==destino){
                System.out.println(g.getLnodos().Obtener(destino).getInformacion()[0]+ " ]");
                break;
            }
            System.out.print(g.getLnodos().Obtener(resultado[i]).getInformacion()[0]+"---> " );
        }
        
         //System.out.println(etiqueta[0]);
        System.out.println(Arrays.toString(resultado));
        
    }   
}
