package estructuras;

public class Nodo {
    
    private Object dato;
    
    private Nodo siguiente;
    
    public Nodo (Object o, Nodo n){
        setDato(o);
        setSiguiente(n);
    }
    
    public Nodo(){
    	
    }

	public Object getDato() {
		return dato;
	}

	public void setDato(Object dato) {
		this.dato = dato;
	}

	public Nodo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}

	@Override
	public String toString() {
		return dato +" y el siguiente a ser atentido es: " + siguiente;
	}

    
}
