import java.util.*;

public class DFS{
    private boolean[] marked;  // marca los vértices visitados
    private int count;         // cantidad de vértices alcanzables desde s

    /**
     * @pre 0 <= s < G.V()
     * @post Realiza DFS desde el vértice s en el grafo G
     */
    public DFS(grafo G, int s) {
        marked = new boolean[G.V()];
        count = 0;
        dfs(G, s);  // <- VOS implementás este método
    }

    /**
     * @post Devuelve true si se alcanzó el vértice v desde s
     */
    public boolean marcado(int v) {
        return marked[v];
    }

    /**
     * @post Devuelve cuántos vértices fueron alcanzados desde s
     */
    public int contar() {
        return count;
    }

    /**
     * @post Recorre el grafo G desde el vértice v en profundidad
     */
    private void dfs(grafo G, int v) {

        G.validarVertice(v);
        
        marked[v] = true;
        count++;

        for(int i : G.adyacentes(v))
        {
            if(!marcado(v))
            {
                dfs(G, i);
            }

        }
    }



    public void bfs(grafo G, int v)
    {
        marked = new boolean[G.V()];
         int[] edgeTo = new int[G.V()];
        Queue<Integer> q = new Queue<Integer>();
        marked[v] = true;
        q.enqueue(v);
        while(!q.isEmpty())
        {
            int s = q.dequeue();
            for(int w : G.adyacentes(v))
            {
                if(!marked[w])
                {
                    marked[w] = true;
                    edgeTo[w] = s;
                    q.enqueue(w);
                }
            }


        }



    }
}


