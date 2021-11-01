
package Lectura;

import Lectura.NodoArreglo;
import java.util.Arrays;


public class ListDatos {
    private NodoArreglo first;
    private NodoArreglo last;
    private int size;

    public ListDatos() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public NodoArreglo getFirst() {
        return first;
    }

    public NodoArreglo getLast() {
        return last;
    }

    public int getSize() {
        return size;
    }

    public void setFirst(NodoArreglo first) {
        this.first = first;
    }

    public void setLast(NodoArreglo last) {
        this.last = last;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty() {  //Consulta si la lista esta vacia
        return first == null;
    }
    
    public void addAtTheStart(String [] l) { //Agrega un nodo al inicio de la lista
        NodoArreglo node = new NodoArreglo(l);
        node.setNumOrden(this.size+1);
        if (this.isEmpty()) {
            this.first = this.last = node;
        } else {
            this.first.setPrevious(node);
            node.setNext(this.first);
            this.first = node;
        }
        size++;
    }
    
    public void printList() { //Imprime la lista
        NodoArreglo node = this.first;
        String list = "";
        while (node != null) {
            System.out.println( Arrays.toString(node.getNumber()));
            node = node.getNext();
        }
       
    }
    
    
}
