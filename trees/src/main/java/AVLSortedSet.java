
import java.util.*;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class AVLSortedSet<T extends Comparable<? super T>> implements SortedSet<T> {

    private class Node {
        T data;
        Node left, right;
        int height;

        Node(T data) {
            this.data = data;
            this.height = 1;
        }
    }

    private Node root;
    private int size;



    @Override
    public boolean add(T x) {
        if(x == null) throw new NoSuchElementException();

        if(contains(x))
        {
            return false;
        }

        root =add(root, x);
        size++;
        return true;
        

    }

    private Node add(Node node, Comparable x)
    {
        if(node == null) return new Node((T)x);

        int cmp = x.compareTo(node.data);

        if(cmp < 0)
        {
            node.left =add(node.left, x);
        }
        else {
        if(cmp > 0)
        {
            node.right = add(node.right, x);

        }
        }
        updateHeight(node);
        return balance(node);


    }

    @Override
    public int size() {

       return size;

    }

    @Override
        public void removeMin() {

            if(root == null) throw new IllegalArgumentException();
            root= removeMin(root);
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

    @Override
    public boolean contains(T key) {
        if(size ==0) return false;

        Node raiz = root;
        int cmp = key.compareTo(raiz.data);

        while (raiz != null){
        
            if(cmp < 0)
            {
                raiz = raiz.left;
            }
            
                if(cmp > 0)
                {
                    raiz = raiz.left;
                }
                else
                {
                    return true;
                }
            

        }
        return false;

    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    
    private void updateHeight(Node node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    private int balanceFactor(Node node) {
        return height(node.left) - height(node.right);
    }

    private Node balance(Node node) {
        int bf = balanceFactor(node);

        if (bf > 1) { // izquierda pesada
            if (balanceFactor(node.left) < 0)
                node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (bf < -1) { // derecha pesada
            if (balanceFactor(node.right) > 0)
                node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        updateHeight(x);
        updateHeight(y);

        return y;
    }
}



  
    

