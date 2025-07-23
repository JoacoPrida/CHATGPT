import org.junit.jupiter.api.Test;

public class PrimTest {
    @Test
    public void testRun() {
        EdgeWeightedIntGraph g = new EdgeWeightedIntGraph();
        Prim p = new Prim();
        p.prim(g,0);
    }
}
