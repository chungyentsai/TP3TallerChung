package estructuras.cola;

import excepciones.EmptyQueueException;
import estructuras.Nodo;

public class Cola implements QueueActions{
	
	
	private Nodo first;
	private Nodo fin;
    int size;
   
    public Cola(){
        first=fin=null;
        size = 0;
    }   
public boolean isEmpty(){
     return first == null;
    }

public void reset(){
            
        }
public void enqueue(Object o){
            Nodo nuevo=new Nodo(o,null);
            if(isEmpty()){
            	first = nuevo;
            	}else{
            		fin.setSiguiente(nuevo);
            }
            fin=nuevo;
            size++;
            }
            
public Object first() throws EmptyQueueException{
	if (isEmpty()){
		throw new EmptyQueueException();
	}else{
		return first;
	}
	
}

public Object dequeue() throws EmptyQueueException{
	if (isEmpty()){
		throw new EmptyQueueException();
	}else{
		 Object o = first.getDato();
		    first = first.getSiguiente();
		    size--;
		    return o;
	}
}



public void print(){
	Nodo aux = new Nodo();
	aux= first;
	if(isEmpty())
        System.out.println("La cola esta vacia!");
    else {
    	while(aux != null){
    		System.out.println("¡@" + aux.getDato());
    		aux = aux.getSiguiente();
    	}
        }
    }
}  
