import java.util.NoSuchElementException;
import java.util.Set;
import java.util.HashSet;

public class SortedMapBST<K extends Comparable<? super K>, V> {
    private class Node {
        K key;
        V value;
        Node left, right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;
    private int size;

    // Inserta o reemplaza el valor asociado a la clave
    public void put(K key, V value) {

        put(root, key, value);

        
    }

    private Node put(Node node, K key, V value)
    {
        if(node == null)
        {
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);

        if(cmp < 0)
        {
            node.left = put(node.left, key, value);

        }
        else if(cmp > 0)
        {
            node.right = put(node.right, key, value);

        }
        else
        {
            node.value = value;

        }
        return node;



    }

    // Elimina la clave y su valor asociado
    public void removeKey(K key) {
       
        if(key != null)
        {
            root = removeKey(root, key);

        }
   
    }


    private Node removeKey(Node node, K key)
    {
        int cmp = key.compareTo(node.key);

        if(cmp < 0)
        {
            node.left= removeKey(node.left, key);
        }
        else if(cmp > 0)
        {
            node.right = removeKey(node.right, key);
        }
        else 
        {
            if( node.left == null)
            {
                size--;
                return node.right;
            }
            else if(node.right == null)
            {
                size--;
                return node.left;

            }
        }
        Node min = node.right;
        while (min.left != null) min = min.left;
        node.key = min.key;
        node.value = min.value;
        node.right = removeKey(node.right, min.key);
        size--;
    
    return node;


    }

    // Devuelve el valor asociado a la clave
    public V get(K key) {
        Node raiz = root;

        while(raiz != null)
        {
            int cmp = key.compareTo(raiz.key);
            if(cmp == 0)
            {
                return raiz.value;
            }

            if(cmp < 0)
            {   
                raiz = raiz.left;

            }
            else
            {
                raiz = raiz.right;

            }
        }

            return null;
    }

    

    // Devuelve la cantidad de pares clave-valor
    public int size() {
        // Implementar
        return size;
    }

    // Devuelve true si el mapa está vacío
    public boolean isEmpty() {
      if(root == null)
      {
        return true;
      }
      return false;
    }

    // Devuelve la clave mínima
    public K min() {

        if(root ==null) throw new NoSuchElementException();

        Node raiz = root;

        while(raiz.left != null)
        {
            raiz = raiz.left;

        }
        return raiz.key;
        


    }

    // Elimina la entrada con la clave mínima
    public void removeMin() {
        if(size == 0) throw new NoSuchElementException();

         root = removeMin(root);
        size--;
        
    }


    private Node removeMin(Node node)
    {
        if(node.left == null)
        {
            return node.right;
        }
        node.left = removeMin(node.left);
        return node; 

    }

    // Devuelve un Set con todas las claves ordenadas
    public Set<K> keySet() {

        Set<K>  set= new HashSet<>();
        inOrder(root, set);
        return set;

       
        


    }

    private void inOrder(Node node, Set<K> set)
    {
        if(node == null) return;
        inOrder(node.left, set);
        set.add(node.key);
        inOrder(node.right, set);




    }

    // Devuelve true si el mapa contiene la clave
    public boolean containsKey(K key) {
        
   Node raiz = root;
   
        
   while(raiz != null)
   {
    int cmp = raiz.key.compareTo(key);
        if(cmp == 0)
        {
            return true;
        }
        if(cmp < 0)
        {
            raiz = raiz.left;
        }
        else if(cmp > 0)
        {
            raiz = raiz.right;
        }
         
       
   }
       

    return false;
    
    }
}
