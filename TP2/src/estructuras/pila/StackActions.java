package estructuras.pila;

import excepciones.LinkedListEmptyException;

public interface StackActions {
    
	public int size();

	public boolean isEmpty();

	public void push(Object o);
	
	public void print();
	
	public void arriba() throws LinkedListEmptyException;

	public Object pop() throws LinkedListEmptyException;   

	public Object cima() throws LinkedListEmptyException;

}
