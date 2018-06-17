package estructuras.cola;
import excepciones.EmptyQueueException;


public interface QueueActions {
    
    boolean isEmpty();

	void reset();

	void enqueue(Object o);
	
	void print();

	Object first() throws EmptyQueueException;

	Object dequeue() throws EmptyQueueException;
}
