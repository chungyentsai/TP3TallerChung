package estructuras.pila;

import estructuras.Nodo;
import excepciones.LinkedListEmptyException;

public class Pila implements StackActions{   
    
	private Nodo top;
    private int size;   
    
    
    public Nodo getTop() {
		return top;
	}
    
	public void setTop(Nodo top) {
		this.top = top;
	}
	
	public Pila(){
        top = null;
        size = 0;
    } 
	
    public int size() {
        return size;
    } 
    
    public boolean isEmpty() {
        return top == null;
    }
    
    public void push(Object o) {
        Nodo n = new Nodo(o, top);
        if (isEmpty()){
        	top = n;
        }else{
        	top=n;
        }
        size++;
    } 
    
    public void EliminarCima()throws LinkedListEmptyException {
    	if(isEmpty()){
    		throw new LinkedListEmptyException();
    	}else{
    		size --;
    	}	
    }
    
    public Object pop() throws LinkedListEmptyException {
        if (isEmpty()){
        	throw new LinkedListEmptyException();
        }else{
        	Object o = top.getDato();
        	top= top.getSiguiente();
        	size--;
            return o ; 
        } 
    }
    
    public Object cima() throws LinkedListEmptyException {
    	Object o = top.getDato();
        if (isEmpty()){
        	throw new LinkedListEmptyException();
        }else{
        	return o;
        }
    }

    public void print(){
    	Nodo nuevo = new Nodo();
    	nuevo= top;
    	if(isEmpty())
            System.out.println("La cola esta vacia!");
        else {
        	while(nuevo != null){
        		System.out.println(nuevo.getDato());
        		nuevo = nuevo.getSiguiente();
        	}
            }
        }

}
