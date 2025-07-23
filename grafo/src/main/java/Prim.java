import java.util.ArrayList;
import java.util.List;

public class Prim {

    private Edge[] edgeTo;              // edgeTo[v] = menor arista que conecta v al MST
    private double[] distTo;            // distTo[v] = peso de la menor arista que conecta v al MST
    private boolean[] marked;           // marked[v] = true si v está en el MST
    private IndexMinPQ<Double> pq;      // cola de prioridad indexada por peso

    /**
     * @post Compute a minimum spanning tree of edge-weighted graph G
     * starting at s.
     */
    public void prim(EdgeWeightedIntGraph G, int s) {
        if(s < 0 || s >= G.V()) throw new IllegalArgumentException();

        edgeTo = new Edge[G.V()]; // menor arista 
        distTo = new double[G.V()]; //peso de la menor arista
        marked = new boolean[G.V()]; // marca si paso o no por ahi
        pq = new IndexMinPQ<Double>(G.V()); // cola de prioridad que gaurda el peso

        for(int v = 0; v < G.V(); v++)
        {
            if(v != s) // a todo lo que sea distinto a s le asigna infinito y los mete en la cola
            {
                distTo[v] = Double.POSITIVE_INFINITY;
                pq.insert(v, distTo[v]);


            }
        }

        distTo[s] = 0.0;  //le asigna 0
        pq.insert(s, distTo[s]); //lo inserta en la cola

        while(!pq.isEmpty())
        {
            int v = pq.delMin(); // guarda el  minimo en v
            marked[v] = true; // lo marca como ya visitado

            for(Edge e : G.adj(v)) //se fija en todos los nodos adyacentes con v
            {
                int w = e.other(v); //

                if(marked[w]) continue; //si w fue marcado continua

                if(e.weight() < distTo[w])  //si la arista e es menor que lo nuevo w
                {
                    distTo[w] = e.weight();  //actualizamos la referencia a w 
                    edgeTo[w] = e;          // gaurdamos esa arista como la menor para conectar a w
                    pq.decreaseKey(w, distTo[w]); //bajamos la prioridad anterior(w), ya que ahora tenemos una mejor oferta que es 

                }


            }


        }





        
    }

    // Devuelve las aristas del MST
    public Iterable<Edge> edges() {
        List<Edge> mst = new ArrayList<>();
        for (Edge e : edgeTo) {
            if (e != null) mst.add(e);
        }
        return mst;
    }

    // Devuelve el peso total del MST
    public double weight() {
        double weight = 0.0;
        for (Edge e : edges()) {
            weight += e.weight();
        }
        return weight;
    }
}

