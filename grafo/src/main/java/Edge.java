public class Edge implements Comparable<Edge> {
    private int from;
    public Edge() {
        this(0);
    }
    public Edge(int from) { this.from = from; }
    public int from() { return from; }
    public int either() { return from; }
    public int other(int v) { return 0; }
    public double weight() { return 0.0; }
    public int compareTo(Edge that) { return Double.compare(this.weight(), that.weight()); }
}
