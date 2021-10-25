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
public class Cola {
    
    Nodo pfirst;
    Nodo plast;
    private int size;

    public Cola() {
        this.pfirst = null;
        this.plast = null;
        this.size = 0;
    }
    
    public void destructor(){
        Nodo temp;
        while(this.pfirst!=null){
            temp=pfirst;
            pfirst=pfirst.getNext();
            temp=null;
        }
    }
    
    public void encolar(int x){
        Nodo pnew=new Nodo(x);
        pnew.setNext(null);
        if(this.pfirst==null){
            pfirst=pnew;
        }else{
            this.plast.setNext(pnew);
        }
        plast=pnew;
        size+=1;
    }
    
    public int desencolar(){
        Nodo temp=pfirst;
        pfirst=pfirst.getNext();
        //temp=null;
        size-=1;
        
        
        
        if(pfirst==null){
            plast=null;   
        }
        
        return temp.getElement();
        
      
    }
    
    public boolean es_vacia(){
        
        return getSize()==0;
        
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }
    
    
    public Nodo leer_cabeza(){
        if(size==0){
            System.out.println("La lista esta vacia");
            return null;
        }
        return pfirst;
    }
    
    
    
    
}
