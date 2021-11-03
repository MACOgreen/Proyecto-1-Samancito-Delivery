/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lectura;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import ClasesGrafo.Grafo;
import ClasesGrafo.Nodos;
import java.io.FileWriter;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
public class ActualizarArchivo {
    Grafo grafo;
    ListDatos pedidos;
    Base_de_Datos base;
    String path;
    File file;
    Nodos aux;
    NodoArreglo nau;
    FileWriter w;
    BufferedWriter bw;

    public ActualizarArchivo(Grafo grafo, ListDatos pedidos, Base_de_Datos base) {
        this.grafo = grafo;
        this.pedidos = pedidos;
        this.base=base;
        this.path=base.getPath();
        System.out.println(path);
        /////////////////////////
       
       
        ////////////////////////
        
        aux=grafo.getLnodos().getFirst();
        try{
            file= new File(path);
            w= new FileWriter(file);
            bw= new BufferedWriter(w);
            PrintWriter pw= new PrintWriter(bw);
           pw.print("Restaurantes");
           pw.append("\n");
           while(aux!=null){
               if("Restaurante".equals(aux.getTipo())){
                   String nuevo="";
                   for(int i=0; i< aux.getInformacion().length;i++){
                       if(i==2){
                           nuevo+=aux.getInformacion()[i];
                       }else{
                          nuevo+=aux.getInformacion()[i]+",";
                       }
                   }
                   pw.append(nuevo);
                   System.out.println(nuevo);
                   pw.append("\n");
               }
               aux=aux.getNext();
           }
           
           pw.print("Clientes");
           pw.append("\n");
           aux=grafo.getLnodos().getFirst();
           while(aux!=null){
               if("Cliente".equals(aux.getTipo())){
                   String nuevo="";
                   for(int i=0; i< aux.getInformacion().length;i++){
                       if(i==3){
                           nuevo+=aux.getInformacion()[i];
                       }else{
                          nuevo+=aux.getInformacion()[i]+",";
                       }
                   }
                   pw.append(nuevo);
                   System.out.println(nuevo);
                   pw.append("\n");
               }
               aux=aux.getNext();
           }
           
            
            pw.append("Pedidos");
            pw.append("\n");
            nau=pedidos.getFirst();
            
            while(nau!=null){
                String nuevo="";
                for(int i=0;i<3;i++){
                    if(i==2){
                        nuevo += nau.getNumber()[i];
                    }else{
                       nuevo += nau.getNumber()[i]+",";
                    }
                }
                pw.append(nuevo);
                System.out.println(nuevo);
                pw.append("\n");
                nau=nau.getNext();
            }
            
            pw.print("Rutas");
            pw.append("\n");
            boolean ciclo=true;
            aux=grafo.getLnodos().getFirst();
            while(aux!=null){
                String nuevo="";
                for(int i=0;i<grafo.getLnodos().getSize();i++){
                    if(!aux.getDistancias()[i].equals("0")){
                        nuevo+= aux.getInformacion()[0]+","+Integer.toString(i) +","+aux.getDistancias()[i];
                        pw.append(nuevo);
                        System.out.println(nuevo);
                        pw.append("\n");
                        nuevo="";
                    }
                }
                aux=aux.getNext();
            }
            JOptionPane.showMessageDialog(null," Archivo guardado exitosamente");
              pw.close();
              bw.close();

        }
        catch(Exception e){
            System.out.println("Error al actualizar"+ e);
        }
        
        
    }
    
    
    
    
    
}
