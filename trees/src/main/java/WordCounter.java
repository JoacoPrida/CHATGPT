import java.util.Iterator;
/**
 * Clase para almacenar conjuntos de palabras, y contar la cantidad
 * de veces que cada palabra fue observada.
*/
public class WordCounter
{
    // Associate each word with a count.
    

    /**
     * @post Crea un WordCounter
     */
    public WordCounter() {
        throw new UnsupportedOperationException("metodo a implementar");
    }
    
    /**
     * @post Almacena el conjunto de palabras input, incrementando 
     *   por cada palabra su cuenta en 1.
     */
    public void addWords(SortedSet<String> input) {
       throw new UnsupportedOperationException("metodo a implementar");
    }
    
    /**
     * @post Retorna todas las palabras almacenadas como un 
     *   conjunto
     */
    public SortedSet<String> getAllWords() {
        throw new UnsupportedOperationException("metodo a implementar");
    }
    
    /**
     * @post Retorna la cantidad de veces que una palabra fue
     *   ingresada
     */
    public int getRepetitions(String word) {
        throw new UnsupportedOperationException("metodo a implementar");
    }
    
    /**
     * @post Retorna verdadero si y solo si word pertenece al
     *   conjunto de palabras que fueron observadas
     */
    public boolean belongsToSet(String word) {
      throw new UnsupportedOperationException("metodo a implementar");       
    }
}
