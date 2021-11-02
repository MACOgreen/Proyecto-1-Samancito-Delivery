/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesGrafo;

import java.util.Arrays;

/**
 * Description: Clase utilizada para crear un grafo.
 *
 * @author Manuel Caceres
 */
public class Grafo {

    private Lista lnodos;

    Nodos aux;
    private  String[][] matrizAD;
    

    /**
     * Description: Constructor de la clase grafo. Para crear un grafo se tiene
     * que pasar una lista que contiene los nodos del grafo. Cada nodo tiene
     * asociado una arreglo donde iran las distancias con respecto a otros
     * nodos.
     *
     * @param matrizADYA
     * @author Manuel Caceres
     */
    public Grafo(Lista listaNodos) {

        this.lnodos = listaNodos;
        aux = lnodos.getFirst();
        while (aux != null) {
            aux.setDistancias(new String[lnodos.getSize()]);

            for (int i = 0; i < lnodos.getSize(); i++) {
                aux.getDistancias()[i] = "0";
            }

            aux = aux.getNext();
        }

    }

    /**
     * Description: Procedimiento que me permite ubicar elementos dentro de los
     * arreglos de cada nodo. Recibe como parametro una ruta del Txt en forma de
     * arreglo, y utiliza esa informacion para ubicar las distancias entre
     * nodos.
     *
     * @param rutas
     * @author Manuel Caceres
     */
    public void rellenarFila(String[] rutas) {
        String identificador = rutas[0];
        aux = getLnodos().getFirst();

        while (aux != null) {

            if (identificador.equals(aux.getInformacion()[0])) {
                Nodos aux2 = getLnodos().getFirst();
                int indice = 0;

                while (aux2 != null) {
                    if (rutas[1].equals(aux2.getInformacion()[0])) {
                        aux.getDistancias()[indice] = rutas[2];
                    }
                    aux2 = aux2.getNext();
                    indice++;
                }
            }
            aux = aux.getNext();
        }
    }

    /**
     * Description: Procedimiento que utiliza los arreglos de cada nodo para
     * crear la matriz de adyacencia del grafo.
     *
     * @author: Manuel Caceres
     */
    public void CrearMatrizAD() {
        this.matrizAD = new String[getLnodos().getSize()][getLnodos().getSize()];
        this.aux = getLnodos().getFirst();
        for (int i = 0; i < getLnodos().getSize(); i++) {
            matrizAD[i] = aux.getDistancias();
            aux = aux.getNext();
        }

        
    


    }

    /**
     * Description: Procedimiento utilizado imprimir las filas de la matriz de
     * adyacencia. Se recorre cada nodo del grafo y se imprime su arreglo
     * asociado. Este procedimiento se utilizo en la elaboracion de este
     * proyecto para comprobar que el grafo funcionara bien.
     *
     * @author Manuel Caceres
     */
    public void ImprimirMatriz() {
        for (int i = 0; i < getLnodos().getSize(); i++) {
            System.out.println(Arrays.toString(getMatrizAD()[i]));
        }
    }

    /**
     * @return the lnodos
     */
    public Lista getLnodos() {
        return lnodos;
    }

    /**
     * @return the matrizAD
     */
    public String[][] getMatrizAD() {
        return matrizAD;
    }

    public boolean existeArista(int origen, int destino) {
        if (matrizAD[origen][destino].equals("0")) {
            return false;
        } else {
            return true;
        }
    }

    public void Actualizar(Lista listaNodos) {
        Nodos aux;
        String[] arr = new String[2];
        Nodos aux2 = new Nodos("Prueba", arr);

        aux = listaNodos.getFirst();
        int indice = 0;

        while (aux != null) {
            aux.setDistancias(new String[lnodos.getSize()]);
            //aux2.setDistancias(matrizAD[indice]);

            for (int i = 0; i < lnodos.getSize(); i++) {
                aux.getDistancias()[i] = "0";
            }

            //for (int i = 0; i < aux2.getDistancias().length; i++) {
            //    aux.getDistancias()[i] = aux2.getDistancias()[i];
                
            //}

            aux = aux.getNext();
            
            
        }
        aux = listaNodos.getFirst();
    
        while(aux != null) {
            aux2.setDistancias(matrizAD[indice]);
            for (int i = 0; i < aux2.getDistancias().length; i++) {
                aux.getDistancias()[i] = aux2.getDistancias()[i];
    
            } 
            aux = aux.getNext();
            indice ++;
            if (indice == aux2.getDistancias().length){
                break;
            }
        }
    }

}
