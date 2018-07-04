package estructuras;

public class ListaSimple implements ListaSimpleInterface{
	
	private Nodo cabeza;
	private int size;
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	public ListaSimple() {
		cabeza = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return cabeza == null;
	}

	public void reset() {
		cabeza = null;	
	}

	public void insertar(Object dato) {
        Nodo nuevo = new Nodo();
        nuevo.setDato(dato);
        if (isEmpty()) {
        	cabeza = nuevo;
        }else{
            nuevo.setSiguiente(cabeza);
            cabeza = nuevo;
        }
        size++;
    }

	public void insertarOrdenado(Comparable d) {
		Nodo nuevo = new Nodo(d);
		Nodo aux = cabeza;
		Nodo aux2 = cabeza;
		if (isEmpty()){
			cabeza = nuevo;
		}else if(d.compareTo(aux.getDato())<0){
			nuevo.setSiguiente(cabeza);
			cabeza = nuevo;
		}else{
			while(aux != null && (d.compareTo(aux.getDato())>0)){
				aux2 = aux;
				aux = aux.getSiguiente();
			}
			aux2.setSiguiente(nuevo);
			nuevo.setSiguiente(aux);
		}
	}

	public void eliminar() {
		cabeza = null;
		size = 0;
	}
	
	public void eliminarI(int posicion){
        if (posicion>=0 && posicion<size){
            if (posicion == 0){
                cabeza = cabeza.getSiguiente();
            }else{
                Nodo aux = cabeza;
                for (int i = 0; i < posicion-1; i++) {
                    aux = aux.getSiguiente();
                }
                Nodo siguiente = aux.getSiguiente();
                aux.setSiguiente(siguiente.getSiguiente());
            }
            size--;
        }
    }

	public void buscar(Comparable d) {
		Nodo nuevo = new Nodo();
		nuevo = cabeza;
		while (nuevo != null){
			nuevo.getSiguiente();
			if (d.compareTo(nuevo.getDato()) == 0){
				System.out.println("Se ha encontrado");
			}else{
				System.out.println("No se ha encontrado");
			}
			
		}
    }
		
	
	
	public void listar() {
        if (!isEmpty()){
            Nodo aux = cabeza;
            int i = 0;
            while(aux != null){
                System.out.print(i + ". " + aux.getDato() + " -> \n");
                aux = aux.getSiguiente();
                i++;
            }
        }
	}

	public boolean BuscarC(Comparable d) {
		Nodo aux = cabeza;
		boolean bandera = false;
		while(aux != null){
		if(d.compareTo(aux.) == 0){
		bandera = true;
		}
		aux = aux.getSiguiente();
		}
		return bandera;
		}

	public Object buscarO (Object o) {
		Nodo aux = cabeza;
		Nodo actual = cabeza;
		while (aux!=null &&((Comparable)aux.getDato()).compareTo(o)!=0)
			aux=aux.getSiguiente();
		if (aux!=null) {
		actual=aux;
		return aux.getDato();
		}
		return null;
		}



	
}
