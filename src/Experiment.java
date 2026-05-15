public class Experiment {

    private String[] labels   = {"Small (10 vertices)", "Medium (30 vertices)", "Large (100 vertices)"};
    private long[]   bfsTimes = new long[3];
    private long[]   dfsTimes = new long[3];

    public void runTraversals(Graph g) {
        System.out.println("--- Traversal output ---");
        g.bfs(0);
        g.dfs(0);
        System.out.println("------------------------");
    }

    public void runMultipleTests() {
        int[] sizes = {10, 30, 100};
        for (int i = 0; i < sizes.length; i++) {
            Graph g = buildGraph(sizes[i]);

            long bfsStart = System.nanoTime();
            silentRun(() -> g.bfs(0));
            bfsTimes[i] = System.nanoTime() - bfsStart;

            long dfsStart = System.nanoTime();
            silentRun(() -> g.dfs(0));
            dfsTimes[i] = System.nanoTime() - dfsStart;
        }
    }

    public void printResults() {
        System.out.println("\n========== Performance Results ==========");
        System.out.printf("%-25s %15s %15s%n", "Graph Size", "BFS (ns)", "DFS (ns)");
        System.out.println("-".repeat(57));
        for (int i = 0; i < labels.length; i++) {
            System.out.printf("%-25s %15d %15d%n", labels[i], bfsTimes[i], dfsTimes[i]);
        }
        System.out.println("=========================================");
    }

    private Graph buildGraph(int n) {
        Graph g = new Graph();
        for (int i = 0; i < n; i++) g.addVertex(new Vertex(i));
        for (int i = 0; i < n; i++) {
            g.addEdge(i, (i + 1) % n);
            g.addEdge(i, (i + 2) % n);
        }
        return g;
    }

    private void silentRun(Runnable r) {
        java.io.PrintStream original = System.out;
        System.setOut(new java.io.PrintStream(java.io.OutputStream.nullOutputStream()));
        r.run();
        System.setOut(original);
    }
}