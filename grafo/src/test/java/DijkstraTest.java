import org.junit.jupiter.api.Test;

public class DijkstraTest {
    @Test
    public void testRun() {
        EdgeWeightedIntDigraph g = new EdgeWeightedIntDigraph();
        new Dijkstra(g,0);
    }
}
