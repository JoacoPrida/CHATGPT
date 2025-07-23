import org.junit.jupiter.api.Test;

public class KruskalTest {
    @Test
    public void testRun() {
        EdgeWeightedIntGraph g = new EdgeWeightedIntGraph();
        Kruskal k = new Kruskal();
        k.kruskal(g);
    }
}
