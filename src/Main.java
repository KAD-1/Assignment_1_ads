public class Main {

    public static void main(String[] args) {

        System.out.println("==============================");
        System.out.println("  SMALL GRAPH (10 vertices)");
        System.out.println("==============================");

        Graph small = new Graph();
        for (int i = 0; i < 10; i++) small.addVertex(new Vertex(i));
        int[][] edges = {
                {0,1},{0,2},{1,3},{1,4},{2,5},{2,6},
                {3,7},{4,7},{5,8},{6,8},{7,9},{8,9}
        };
        for (int[] e : edges) small.addEdge(e[0], e[1]);

        small.printGraph();
        System.out.println();
        new Experiment().runTraversals(small);

        System.out.println("\n==============================");
        System.out.println("  MEDIUM GRAPH (30 vertices)");
        System.out.println("==============================");
        Graph medium = buildGraph(30);
        long s = System.nanoTime(); medium.bfs(0); System.out.println("BFS time: " + (System.nanoTime() - s) + " ns");
        s = System.nanoTime();      medium.dfs(0); System.out.println("DFS time: " + (System.nanoTime() - s) + " ns");

        System.out.println("\n==============================");
        System.out.println("  LARGE GRAPH (100 vertices)");
        System.out.println("==============================");
        Graph large = buildGraph(100);
        s = System.nanoTime(); large.bfs(0); System.out.println("BFS time: " + (System.nanoTime() - s) + " ns");
        s = System.nanoTime(); large.dfs(0); System.out.println("DFS time: " + (System.nanoTime() - s) + " ns");

        System.out.println("\n====================================");
        System.out.println("  FULL EXPERIMENT (all 3 sizes)");
        System.out.println("====================================");
        Experiment exp = new Experiment();
        exp.runMultipleTests();
        exp.printResults();
    }

    private static Graph buildGraph(int n) {
        Graph g = new Graph();
        for (int i = 0; i < n; i++) g.addVertex(new Vertex(i));
        for (int i = 0; i < n; i++) {
            g.addEdge(i, (i + 1) % n);
            g.addEdge(i, (i + 2) % n);
        }
        return g;
    }
}
//public class Main {
//    public static void main(String[] args) {
//        new Experiment().runAllExperiments();
//    }
//}