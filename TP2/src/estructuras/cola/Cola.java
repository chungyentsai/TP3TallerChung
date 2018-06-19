package estructuras.cola;

import excepciones.EmptyQueueException;
import estructuras.Nodo;

public class Cola implements QueueActions{
	
	
	private Nodo front;
	private Nodo fin;
    int size;
    
    
    
    
    public Nodo getFront() {
		return front;
	}
	public void setFront(Nodo front) {
		this.front = front;
	}
	
	
	public Cola(){
        front=fin=null;
        size = 0;
    }   
public boolean isEmpty(){
     return front == null;
    }

public void reset(){
           front=null;
        }
public void enqueue(Object o){
            Nodo nuevo=new Nodo(o,null);
            if(isEmpty()){
            	front = nuevo;
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
		return front;
	}
	
}

public Object dequeue() throws EmptyQueueException{
	if (isEmpty()){
		throw new EmptyQueueException();
	}else{
		 Object o = front.getDato();
		    front = front.getSiguiente();
		    size--;
		    return o;
	}
}

public void print(){
	Nodo aux = new Nodo();
	aux= front;
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
