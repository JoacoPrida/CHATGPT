import java.util.*;

public class grafo {
    private final int V;                 // cantidad de vértices
    private int E;                       // cantidad de aristas
    private List<Integer>[] adj;        // listas de adyacencia

    /**
     * Inicializa un grafo con V vértices y 0 aristas.
     */
    public grafo(int V) {
        if (V < 0) throw new IllegalArgumentException("Cantidad de vértices negativa");
        this.V = V;
        this.E = 0;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * Devuelve la cantidad de vértices.
     */
    public int V() {
        return V;
    }

    /**
     * Devuelve la cantidad de aristas.
     */
    public int E() {
        return E;
    }

    /**
     * Agrega una arista no dirigida entre v y w.
     */
    public void agregarArista(int v, int w) {
        validarVertice(v);
        validarVertice(w);
        adj[v].add(w);
        adj[w].add(v); // porque es no dirigido
        E++;
    }

    /**
     * Devuelve la lista de adyacentes al vértice v.
     */
    public Iterable<Integer> adyacentes(int v) {
        validarVertice(v);
        return adj[v];
    }

    /**
     * Verifica que el vértice sea válido.
     */
    public void validarVertice(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("Vértice inválido: " + v);
    }

    /**
     * Representación del grafo como string.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vertices: ").append(V).append(", Aristas: ").append(E).append("\n");
        for (int v = 0; v < V; v++) {
            sb.append(v).append(": ");
            for (int w : adj[v]) {
                sb.append(w).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
