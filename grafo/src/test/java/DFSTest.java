import org.junit.jupiter.api.Test;

public class DFSTest {
    @Test
    public void testDFSConstructor() {
        grafo g = new grafo(1);
        new DFS(g,0);
    }
}
