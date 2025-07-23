import org.junit.jupiter.api.Test;

public class FloydWarshallTest {
    @Test
    public void testRun() {
        EdgeWeightedIntDigraph g = new EdgeWeightedIntDigraph();
        new FloydWarshall(g);
    }
}
