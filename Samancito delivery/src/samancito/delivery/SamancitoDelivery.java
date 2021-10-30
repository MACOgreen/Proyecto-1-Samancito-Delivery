
package samancito.delivery;


import ClasesGrafo.Grafo;
import ClasesGrafo.Lista;
import ClasesGrafo.Recorridos;
import Lectura.*;



/**
 *
 * @author mani
 */
public class SamancitoDelivery {

    
    
    
    /*
    static Lista l= new Lista();
    static String tipo;
    static Grafo grafo;
    static Recorridos re= new Recorridos();
    */
    public static void main(String[] args) {
        ListDatos pedidos;
        Grafo grafo;
        
        
        Base_de_Datos bdatos= new Base_de_Datos();
        
        //Lista de pedidos
        pedidos=bdatos.datos();
        //Grafo obtenidor de leer la base de datos. 
        grafo=bdatos.getGrafo();
        
        grafo.ImprimirMatriz();
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*
        tipo="Restaurante";
        String[] informacion = {"A","Pizpa","Pizza", "Margarita","Pasticho","Refresco"};
        l.addAtTheEnd(tipo, informacion);
        
        tipo="Restaurante";
        String[] informacion2={"B","Sótano Siete","Prosciutto Funghi","Pizza Napoletana","Calzone"};
        l.addAtTheEnd(tipo, informacion2);
        
        tipo="Cliente";
        String[] informacion3={"1","Pepe","Gónzales","234354"};
        l.addAtTheEnd(tipo, informacion3);
        
        
        
        grafo=new Grafo(l);
        
        String[] ruta1={"A","1","3"};
        grafo.rellenarFila(ruta1);
        
       
        
        
        String[] ruta2={"B","1","5"};
        grafo.rellenarFila(ruta2);
        
        
        String[] ruta3={"A","B","2"};
        grafo.rellenarFila(ruta3);
        
        
        grafo.CrearMatrizAD();
        grafo.ImprimirMatriz();
        
        
        re.profundidad(grafo);
        
        
        re.amplitud(grafo);
        */
        
    }
    
}

