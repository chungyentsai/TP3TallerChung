package estructuras;

public interface ListaSimpleInterface {
	
	
	boolean isEmpty();
	
	void reset();

	void insertar(Object dato);
	
	void insertarOrdenado(Comparable d);
	
	void eliminar();
	
	void eliminarI(int posicion);
	
	void buscar(Comparable d);
	
	void listar();
	
	
}
