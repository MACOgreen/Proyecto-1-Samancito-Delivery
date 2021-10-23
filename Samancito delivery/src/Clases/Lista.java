/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author mani
 */
public class Lista {
    
    private Nodos first;
    private Nodos Last;
    private int size;

    public Lista() {
        this.first = null;
        this.Last = null;
        this.size=0;
    }

    /**
     * @return the first
     */
    public Nodos getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(Nodos first) {
        this.first = first;
    }

    /**
     * @return the Last
     */
    public Nodos getLast() {
        return Last;
    }

    /**
     * @param Last the Last to set
     */
    public void setLast(Nodos Last) {
        this.Last = Last;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {  // Falta asegurarla de errores
        this.size = size;
    }
    
    public boolean isEmpty(){
        return first==null;
    }
    
    public void empty(){
        this.first=null;
        this.Last =null;
        this.size=0;
    }
    //Agregar elemento al final de la lista. Crea un nodo nuevo automaticamente. 
    
    public void addAtTheEnd(String tipo, String[] informacion){
        
        
        Nodos newNodo= new Nodos( tipo, informacion); 
        
        if(this.isEmpty()){
            first=Last=newNodo;
            Last=newNodo;
        }else{
            Last.setNext(newNodo);
            Last=newNodo;
        }
        size++;
        
    }
    
    public void DeleteAtTheStart(){
        if(!this.isEmpty()){
            if(size==1){
                this.empty();
            }else{
                first=first.getNext();
                size--;
            }
        }
    }
    ///Procedimiento para imprimir
    public void print(){
        Nodos temp=first;
        if(this.isEmpty()){
            System.out.println("The list is  empty.");
        }
        while(temp!=null){
            System.out.println(temp.getInformacion()[0]);
            temp=temp.getNext();
        }
    }
    
    ///Procedimiento para modificar cualquiqer elemento en la lista
    
    public void modificar(int posicion,String[] nuevoValor){  // Falta asegurarla de errores
        Nodos temp=first;
        int i=0;
        
        while(i!=posicion){
            temp=temp.getNext();
            i++;
        }
        temp.setDistancias(nuevoValor);
          
    }
    
    
    public void Eliminar(int posicion){ // Falta asegurarla de errores
        Nodos temp=first;
        Nodos temp2=first;
        int i=0;
        
        if(i==posicion){
            DeleteAtTheStart();
        }else{
            while(i!=posicion){
                temp2=temp;         //Posicion anterior del nodo que quiero eliminar
                temp=temp.getNext(); //Posicion del nodo que quiero eliminar
                i++;      
            }
            temp2.setNext(temp.getNext()); //Modifico el enlace del nodo anterior para que se salte el nodo que quiero eliminar.
            size--;
        }    
    }
    
    
    
    
    public Nodos Obtener(int posicion){ // Falta asegurarla de errores
        int i=0;
        Nodos temp=first;
        
        while(i!=posicion){
            temp=temp.getNext();
            i++;
        }         
        return temp;
    }
    
    /** 
     * @author: Manuel Caceres
     * @param posicion1 posicion anterior a donde quiero insertar.
     * @param posicion2 posicion posterior a donde quiero insertar.
     * @param elementoNuevo Elemento que quiero insertar. 
    */
    
    /*
    public void Insertar(int posicion1,int posicion2,String[] elementoNuevo){  // Falta asegurarla de errores
        
        Nodos temp=Obtener(posicion1);
        Nodos temp2=Obtener(posicion2);
        Nodos nuevoNodo=new Nodos(elementoNuevo);
        
        temp.setNext(nuevoNodo); 
        nuevoNodo.setNext(temp2);
        
        size++;
        
        
        
    }
    */   
}
