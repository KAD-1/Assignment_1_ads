import java.util.*;

public class Graph {

    private Map<Integer, Vertex> vertices;
    private Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        vertices = new HashMap<>();
        adjacencyList = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        if (!vertices.containsKey(v.getId())) {
            vertices.put(v.getId(), v);
            adjacencyList.put(v.getId(), new ArrayList<>());
        }
    }

    public void addEdge(int from, int to) {
        if (!vertices.containsKey(from) || !vertices.containsKey(to)) {
            System.out.println("Warning: vertex not found for edge " + from + " -> " + to);
            return;
        }
        adjacencyList.get(from).add(to);
    }

    public void printGraph() {
        System.out.println("Graph adjacency list:");
        List<Integer> ids = new ArrayList<>(adjacencyList.keySet());
        Collections.sort(ids);
        for (int id : ids) {
            System.out.println("  " + id + " -> " + adjacencyList.get(id));
        }
    }

    public void bfs(int start) {
        if (!vertices.containsKey(start)) return;

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>(); // FIFO — visit neighbours level by level

        queue.add(start);
        visited.add(start);

        System.out.print("BFS from " + start + ": ");
        while (!queue.isEmpty()) {
            int current = queue.poll(); // dequeue front vertex
            System.out.print(current + " ");
            for (int neighbour : adjacencyList.get(current)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour); // mark before enqueue to avoid duplicates
                    queue.add(neighbour);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int start) {
        if (!vertices.containsKey(start)) return;

        Set<Integer> visited = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>(); // LIFO — go deep before backtracking

        stack.push(start);

        System.out.print("DFS from " + start + ": ");
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited.contains(current)) {
                visited.add(current);
                System.out.print(current + " ");
                List<Integer> neighbours = adjacencyList.get(current);
                // push in reverse so first neighbour is processed next
                for (int i = neighbours.size() - 1; i >= 0; i--) {
                    if (!visited.contains(neighbours.get(i))) {
                        stack.push(neighbours.get(i));
                    }
                }
            }
        }
        System.out.println();
    }

    public int vertexCount() { return vertices.size(); }

    public int edgeCount() {
        int count = 0;
        for (List<Integer> n : adjacencyList.values()) count += n.size();
        return count;
    }
}