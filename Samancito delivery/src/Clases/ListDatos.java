
package Clases;

import java.util.Arrays;


class ListDatos {
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
            list += node.getNumber() + ",";
            node = node.getNext();
        }
        System.out.println(list);
    }
    
    
}
