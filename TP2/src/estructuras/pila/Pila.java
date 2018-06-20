package estructuras.pila;
import estructuras.Nodo;
import excepciones.LinkedListEmptyException;

public class Pila implements StackActions{   
    
	Nodo top;
    int size;   
    
    
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
        	top.setSiguiente(top);
        	top=n;
        }
        size++;
    } 
    
    public Object pop() throws LinkedListEmptyException {
    	Object o;
        if (isEmpty()){
        	throw new LinkedListEmptyException();
        }else{
        	o = top.getDato();
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
    	Nodo aux = new Nodo();
    	aux= top;
    	if(isEmpty())
            System.out.println("La cola esta vacia!");
        else {
        	while(aux != null){
        		System.out.println(aux.getDato());
        		aux = aux.getSiguiente();
        	}
            }
        }

}
