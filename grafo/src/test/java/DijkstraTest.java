import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DijkstraTest {
    @Test
    public void testRun() {
        EdgeWeightedIntDigraph g = new EdgeWeightedIntDigraph();
        assertThrows(IllegalArgumentException.class, () -> new Dijkstra(g, 0));
    }
}
