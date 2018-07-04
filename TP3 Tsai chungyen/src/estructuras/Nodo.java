package estructuras;

import modelos.Documento;

public class Nodo implements Comparable<Object>{
    
    private Object dato;    
    private Nodo siguiente;
    
    public Nodo (Object o){
        setDato(o);  
    }   
    public Nodo(){
    	
    }  
    public void Nodo(){
    	dato = null;
    	siguiente = null;
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
		return "" + dato +" ";
	}

	public int compareTo (Object d){
		int resultado = 0;
		if (d instanceof Documento){
			resultado = compareTo(d);
		}
		return resultado;
	}

}
