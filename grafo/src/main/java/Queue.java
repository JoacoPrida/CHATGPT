
    import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Queue<T> {
    private LinkedList<T> lista;

    public Queue() {
        lista = new LinkedList<>();
    }

    public boolean isEmpty() {
        return lista.isEmpty();
    }

    public int size() {
        return lista.size();
    }

    // Método para encolar (agregar al final)
    public void enqueue(T item) {
        
        lista.addFirst(item);
        
    }

    // Método para desencolar (quitar del principio)
    public T dequeue() {

        if(isEmpty()) throw new NoSuchElementException();

        T deleted = lista.getFirst();

         lista.removeFirst();

         return deleted;
        
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("La cola está vacía");
        return lista.getFirst();
    }
}


    

