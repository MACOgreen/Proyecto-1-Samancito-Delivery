/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mostrargrafo;

import ClasesGrafo.Grafo;
import ClasesGrafo.Lista;
import ClasesGrafo.Nodos;
import Lectura.*;
import java.lang.Math;

public class mostrarG {
    
    Grafo G;
    int x;
    int y;
    Nodos aux;
    Lista lno;
    int[] coordenadasX;
    int[] coordenadasY;
    String[][] matrizAD;
    
    
    public int getRandomNumber(int min, int max, int[] arreglo) {
        boolean ciclo=true;
        int numero=0;
        
        while(ciclo){
            numero=(int) ((Math.random() * (max - min)) + min);
            for(int i =0;i<arreglo.length;i++){
                if(numero==arreglo[i]){
                    ciclo=true;
                }
                else{
                    ciclo=false;
                }      
            }        
        }
        int i=arreglo.length-1;
        arreglo[i]=numero;
        return numero;
    }
    

    public mostrarG(Grafo G) {
        this.G = G;
        
        lno=G.getLnodos();
        matrizAD=G.getMatrizAD();
        aux=lno.getFirst();
        
        coordenadasX= new int[lno.getSize()];
        coordenadasX[0]=0;
        coordenadasY= new int[lno.getSize()];
        coordenadasY[0]=0;
        
        GraphDraw frame = new GraphDraw("Test Window");
	frame.setSize(2000,2000);
	frame.setVisible(true);
        
        while(aux!=null){
            
            x=getRandomNumber(50, 900,coordenadasX);
            y=getRandomNumber(50, 900,coordenadasY);
            
            frame.addNode(aux.getInformacion()[0],x,y);
            
            aux=aux.getNext();
            
        }
        String peso;
        for(int i=0;i<lno.getSize();i++){
            for(int j=0;j<lno.getSize();j++){
                peso=matrizAD[i][j];
                if(!peso.equals("0")){
                    frame.addEdge(i,j,peso);
                }
            }
        }
        
        
        
        
        
        
        
        
        
    }
    
    
    
    
}
