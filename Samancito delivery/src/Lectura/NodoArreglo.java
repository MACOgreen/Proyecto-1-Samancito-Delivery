/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lectura;


public class NodoArreglo {
    private String [] l;
    private NodoArreglo next;
    private NodoArreglo previous;

    public NodoArreglo(String [] l) { 
        this.l = l;
        this.next = null;
        this.previous = null;
    }

    public String [] getNumber() {
        return l;
    }

    public NodoArreglo getNext() {
        return next;
    }

    public NodoArreglo getPrevious() {
        return previous;
    }

    public void setNumber(String [] l) {
        this.l = l;
    }

    public void setNext(NodoArreglo next) {
        this.next = next;
    }

    public void setPrevious(NodoArreglo previous) {
        this.previous = previous;
    }
}
