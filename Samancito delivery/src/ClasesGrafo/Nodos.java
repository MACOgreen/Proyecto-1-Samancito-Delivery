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
public class Nodos {
    private Nodos next;
    private String[] distancias;
    private String tipo;
    private String[] informacion; 
    /**
     * Description: Constructor del nodo.  Un nodo va a tener un tipo, informacion, y distancias.
     * @param tip
     * @param informacion
     * @param distancias 
     */
    public Nodos(String tip,String[] informacion ){
        this.next = null;
        //this.distancias = distancias; 
        this.tipo=tip;
        this.informacion=informacion;
        
        
          
    }

    /**
     * @return the next
     */
    public Nodos getNext() {
        return next;
    }
    
    public Nodos setNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Nodos next) {
        this.next = next;
    }

    /**
     * @return the element
     */
    public String[] getDistancias() {
        return distancias;
    }

    /**
     * @param element the element to set
     */
    public void setDistancias(String[] element) {
        distancias = element;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the informacion
     */
    public String[] getInformacion() {
        return informacion;
    }

    /**
     * @param informacion the informacion to set
     */
    public void setInformacion(String[] informacion) {
        this.informacion = informacion;
    }
    
    
    
}