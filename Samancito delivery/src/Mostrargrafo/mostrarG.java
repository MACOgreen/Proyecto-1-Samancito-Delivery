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
import java.awt.Color;
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
        int diferencia;
        
        while(ciclo){
            numero=(int) ((Math.random() * (max - min)) + min);
            for(int i =0;i<arreglo.length;i++){
                diferencia= numero-arreglo[i];
                
                if(diferencia<0){
                    diferencia=diferencia*-1;
                    if(diferencia<70){
                        numero=numero+100;
                    }
                        
                }
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
        
        GraphDraw frame = new GraphDraw("Grafo");
        frame.setResizable(false);
	frame.setSize(1300,1300);
        
	frame.setVisible(true);
        
        while(aux!=null){
            
            x=getRandomNumber(50, 1200,coordenadasX);
            y=getRandomNumber(50,860,coordenadasY);
            
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
