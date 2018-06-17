package estructuras.pila;

import excepciones.LinkedListEmptyException;

public interface StackActions {
    
	public int size();

	public boolean isEmpty();

	public void push(Object objectToPush);

	public Object pop() throws LinkedListEmptyException;   

	public Object peek() throws LinkedListEmptyException;

}
