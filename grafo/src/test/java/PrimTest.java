import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrimTest {
    @Test
    public void testRun() {
        EdgeWeightedIntGraph g = new EdgeWeightedIntGraph();
        Prim p = new Prim();
        assertThrows(IllegalArgumentException.class, () -> p.prim(g, 0));
    }
}
