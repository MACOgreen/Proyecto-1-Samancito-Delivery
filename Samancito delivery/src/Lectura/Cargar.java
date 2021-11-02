/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lectura;

import java.io.File;
import javax.swing.*;

/**
 *
 * @author mani
 */
public class Cargar {
    String aux;   
    String texto;
    JFileChooser file;
    
    public File abrirArchivo(){
        
        String aux="";   
        texto="";
        
        
        /**llamamos el metodo que permite cargar la ventana*/
       file=new JFileChooser();
       
       file.showOpenDialog(file);
       /**abrimos el archivo seleccionado*/
       File abre=file.getSelectedFile();
       
       return abre;
       
        
    }
    
}
