import java.util.NoSuchElementException;
import java.util.Stack;

public class Dijkstra {
    private double[] distTo;                // distTo[v] = distancia más corta desde s a v
    private DirectedEdge[] edgeTo;          // edgeTo[v] = última arista en el camino más corto a v
    private IndexMinPQ<Double> pq;          // cola de prioridad indexada por distancia

    /**
     * @pre 0=<s<V && G has no edges with negative weight
     * @post Computes the shortest paths from the source vertex s to every other
     * vertex in the edge-weighted digraph G.
     */
    public Dijkstra(EdgeWeightedIntDigraph G, int s) {
        if(s < 0 || s >= G.V()) throw new IllegalArgumentException();

        distTo = new double[G.V()];    //distancia mas corta de s a v
        edgeTo = new DirectedEdge[G.V()];  //ultima arista en el camino mas corto a v
        pq = new IndexMinPQ<Double>(G.V());  //cola de prioridada donde se  guarda la distancia de nodo en nodo

        for(int v = 0; v < G.V(); v++)   //for que se enecarga de que a todos menos s les asigna una distancia inicial de ifninito , porque no se conoce su origen todavia                             //
        {      
                                      //y insertar todoso los elementos distintos a s en la cola con una distancia inifinita distTo(infinity)
        if(v != s)
        {   
            distTo[v] = Double.POSITIVE_INFINITY;
            pq.insert(v, distTo[v]);

        }


        }

        distTo[s] = 0.0;  // lo inicializa en 0 porque es el primero
        pq.insert(s, distTo[s]); //lo inserta a la cola
        
        while(!pq.isEmpty())
        {
            int v = pq.delMin();    //saca de la cola el vertice v con la menor distancia desde el origen s 
            for(DirectedEdge e : G.adj(v)) //recorre todas las aristas que salen de V dirigidas
            {
                relax(e); //intenta relajar e (si el camino pasando por e es mas corto se actualiza, eso es relajar)
            }

        }


        
    }

    // Relaja la arista e en el contexto del algoritmo de Dijkstra
    private void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
            else                pq.insert(w, distTo[w]);
        }
    }

    // Devuelve la distancia más corta desde el origen a v
    public double distTo(int v) {
        return distTo[v];
    }

    // ¿Existe un camino desde el origen a v?
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    // Devuelve el camino más corto desde el origen a v como un iterable de aristas
    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }




    

}
