import org.junit.jupiter.api.Test;

public class BFSTest {
    @Test
    public void testBFSExecution() {
        grafo g = new grafo(1);
        DFS dfs = new DFS(g,0);
        dfs.bfs(g,0);
    }
}
