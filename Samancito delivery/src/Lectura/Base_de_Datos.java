package Lectura;

import ClasesGrafo.Grafo;
import ClasesGrafo.Lista;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class Base_de_Datos {
    Cargar cargar= new Cargar();  //Para cargar archivo.
    private Grafo grafo;
    File file;
    private String path;
    
    public void printArreglo(String[] l) { //Imprime la lista
        System.out.println(Arrays.toString(l));
    }

    public ListDatos datos() {
        ListDatos pedidos = new ListDatos();
        String line;
        String samancito_txt = "";
        try{
            file= cargar.abrirArchivo();
            path=file.getPath();
            
        }catch(Exception ex){
            
            //path = "test\\samancito.txt";
            //file = new File(getPath());   
            
        }
        
        
        //Objetos para grafos
        Lista l = new Lista();
        String tipo;
        
        //
        
        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine()) != null) {
                    if (!line.isEmpty()) {
                        samancito_txt += line + "\n";
                    }
                }

                if (!"".equals(samancito_txt) && !samancito_txt.isEmpty()) {
                    String[] datos_split = samancito_txt.split("\n");
                    for (int i = 0; i < datos_split.length; i++) {
                        if (datos_split[i].equals("Restaurantes")) {
                            int j = i+1;
                            tipo="Restaurante";
                            
                            while (!datos_split[j].equals("Clientes")) {
                                String[] alldatos = datos_split[j].split(",");
                                l.addAtTheEnd(tipo, alldatos);
                                //printArreglo(alldatos);
                                //restaurantes.addAtTheStart(datos_split);
                                j++;
                            }

                        } else if (datos_split[i].equals("Clientes")) {
                            int j = i+1;
                            tipo="Cliente";
                            
                            while (!datos_split[j].equals("Pedidos")) {
                                String[] alldatos = datos_split[j].split(",");
                                l.addAtTheEnd(tipo, alldatos);
                                //l.addAtTheEnd(tipo, alldatos);
                                //clientes.addAtTheStart(datos_split);
                                j++;
                            }
                            
                            
                        } else if (datos_split[i].equals("Pedidos")) {
                            int j = i+1;
                            while (!datos_split[j].equals("Rutas")) {
                                String[] alldatos = datos_split[j].split(",");
                                System.out.println(alldatos);
                                pedidos.addAtTheStart(alldatos); 
                                

                                j++;
                            }
                            
                            //pedidos.printList();
                        } else if (datos_split[i].equals("Rutas")){
                            
                            //Se crea el grafo
                            grafo=new Grafo(l);
                            //
                            int j = i+1;
                            while (true) {
                                if (datos_split.length - j == 0){
                                    break;
                                }
                                String[] alldatos = datos_split[j].split(",");
                                //printArreglo(alldatos);
                                getGrafo().rellenarFila(alldatos);
                                j++;
                            }
                            
                            getGrafo().CrearMatrizAD();
                        }

                    }
                }
                br.close();
                JOptionPane.showMessageDialog(null, "Exito al leer");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al leer. Se va a cargar un archivo default.");
            
            return Lecturadefault();
        }
        return pedidos;
        

    }
    
    public ListDatos Lecturadefault(){
        
        ListDatos pedidos = new ListDatos();
        
        String line;
        String samancito_txt = "";
         
        path = "test\\samancito.txt";
        file = new File(getPath());   
        
        
        
        //Objetos para grafos
        Lista l = new Lista();
        String tipo;
        
        //
        
        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine()) != null) {
                    if (!line.isEmpty()) {
                        samancito_txt += line + "\n";
                    }
                }

                if (!"".equals(samancito_txt) && !samancito_txt.isEmpty()) {
                    String[] datos_split = samancito_txt.split("\n");
                    for (int i = 0; i < datos_split.length; i++) {
                        if (datos_split[i].equals("Restaurantes")) {
                            int j = i+1;
                            tipo="Restaurante";
                            
                            while (!datos_split[j].equals("Clientes")) {
                                String[] alldatos = datos_split[j].split(",");
                                l.addAtTheEnd(tipo, alldatos);
                                //printArreglo(alldatos);
                                //restaurantes.addAtTheStart(datos_split);
                                j++;
                            }

                        } else if (datos_split[i].equals("Clientes")) {
                            int j = i+1;
                            tipo="Cliente";
                            
                            while (!datos_split[j].equals("Pedidos")) {
                                String[] alldatos = datos_split[j].split(",");
                                l.addAtTheEnd(tipo, alldatos);
                                //l.addAtTheEnd(tipo, alldatos);
                                //clientes.addAtTheStart(datos_split);
                                j++;
                            }
                            
                            
                        } else if (datos_split[i].equals("Pedidos")) {
                            int j = i+1;
                            while (!datos_split[j].equals("Rutas")) {
                                String[] alldatos = datos_split[j].split(",");

                                pedidos.addAtTheStart(alldatos); 
                                

                                j++;
                            }
                            
                            //pedidos.printList();
                        } else if (datos_split[i].equals("Rutas")){
                            
                            //Se crea el grafo
                            grafo=new Grafo(l);
                            //
                            int j = i+1;
                            while (true) {
                                if (datos_split.length - j == 0){
                                    break;
                                }
                                String[] alldatos = datos_split[j].split(",");
                                //printArreglo(alldatos);
                                getGrafo().rellenarFila(alldatos);
                                j++;
                            }
                            
                            getGrafo().CrearMatrizAD();
                        }

                    }
                }
                br.close();
                JOptionPane.showMessageDialog(null, "Exito al leer el archivo default.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al leer al leer el archivo default.");
            
        }
        return pedidos;
        
        
        
        
        
    }

    /**
     * @return the grafo
     */
    public Grafo getGrafo() {
        return grafo;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

}
