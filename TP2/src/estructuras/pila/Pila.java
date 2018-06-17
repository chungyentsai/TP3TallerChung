package estructuras.pila;
import estructuras.Nodo;
import excepciones.LinkedListEmptyException;

public class Pila implements StackActions{   
    Nodo peek;
    int size;   
    
    
    public Pila(){
        peek = null;
        size = 0;
    }  
    public int size() {
        return size;
    } 
    public boolean isEmpty() {
        return (peek == null);
    }
    public void push(Object o) {
        Nodo n = new Nodo(o, peek);
        peek = n;
        size ++;
    } 
    public Object pop() throws LinkedListEmptyException {
        if (isEmpty())
            throw new LinkedListEmptyException();
            Object temporal = peek.getDato();
            peek= peek.getSiguiente();
            size --;
            return temporal; 
    }
    
    public Object peek() throws LinkedListEmptyException {
        if (isEmpty())
            throw new LinkedListEmptyException();

       return peek.getDato();
    }
    
    public void Mostrar(){
    	try {
			peek();
		} catch (LinkedListEmptyException e) {
			e.printStackTrace();
		}
    }
    
    
}
