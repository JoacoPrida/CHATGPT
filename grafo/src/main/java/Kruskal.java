
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Kruskal {



    private List<Edge> mst;      // Aristas del árbol de expansión mínima
    private double weight;       // Peso total del MST

    public Kruskal() {
        mst = new ArrayList<>();
        weight = 0.0;
    }

    /**
     * @post Compute a minimum spanning tree of edge-weighted graph G.
     */
    public void kruskal(EdgeWeightedIntGraph G) {

        Edge[] edges =new edges[G.E()];
        int t = 0;
        for(Edge e: G.edges())
        {
            edges[t++] = e;

        }

        Arrays.sort(edges);

        UF uf = new UF(G.V());

        for(int i = 0; i < G.E()  && mst.size() < G.V() -1; i++)
        {
            Edge e = edges[i];
            int v = e.from();
            int w = e.other(v);

            if(uf.find(v) != uf.find(w))
            {
                uf.union(v, w);
                mst.add(e);
                weight += e.weight();

            }




        }




        
    }

    // Devuelve las aristas del MST
    public Iterable<Edge> edges() {
        return mst;
    }

    // Devuelve el peso total del MST
    public double weight() {
        return weight;
    }
}

// Stub para Edge
// ...existing code...
class Edge implements Comparable<Edge> {
    private int from; // vértice de origen

    public Edge(int from) {
        this.from = from;
    }

    public int from() { return from; }
    public int either() { return from; }
    public int other(int v) { return 0; }
    public double weight() { return 0.0; }
    public int compareTo(Edge that) {
        return Double.compare(this.weight(), that.weight());
    }
}
// ...existing code...

// Stub para EdgeWeightedIntGraph
class EdgeWeightedIntGraph {
    public int V() { return 0; }
    public int E() { return 0; }
    public Iterable<Edge> edges() { return null; }
}

// Stub para UF (Union-Find)
class UF {
    public UF(int n) {}
    public int find(int p) { return 0; }
    public void union(int p, int q) {}
}
    
