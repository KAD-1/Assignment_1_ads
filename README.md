A. Project Overview
A graph is a data structure that consists of vertices (nodes) and edges (connections between nodes). In this project, a directed graph is implemented using an adjacency list.

Vertex is a single node in the graph with a unique id
Edge is a directed connection from one vertex to another
BFS (Breadth-First Search) is a traversal that explores all neighbours at current depth before going deeper
DFS (Depth-First Search) is a traversal that goes as deep as possible before backtracking


B. Class Descriptions
Vertex represents a node with a unique integer id.
Edge represents a directed connection from source to destination.
Graph stores vertices and edges and provides BFS and DFS traversal.
Experiment builds test graphs, measures execution time and prints results.
Main is the entry point that creates graphs and runs all experiments.
Adjacency List
Each vertex maps to a list of its direct neighbours. It is used instead of a matrix because it is memory efficient: O(V + E) space vs O(V^2) for a matrix.

C. Algorithm Descriptions
BFS (Breadth-First Search)
Step by step:

Add start vertex to a queue and mark it visited
While queue is not empty, dequeue the front vertex
Print it, then enqueue all unvisited neighbours

Use cases: shortest path in unweighted graphs, level-order traversal, web crawlers
Time complexity: O(V + E)
DFS (Depth-First Search)
Step by step:

Push start vertex onto a stack
While stack is not empty, pop the top vertex
If not visited, mark it, print it, push all unvisited neighbours

Use cases: cycle detection, topological sort, maze solving, connected components
Time complexity: O(V + E)

D. Experimental Results
Graph Size -- BFS (ns) -- DFS (ns)
10 vertices -- --
30 vertices -- --
100 vertices -- --
Fill in the table with values from your console output after running the program.
Observations
Execution time grows linearly with graph size, confirming O(V + E) complexity. DFS is slightly faster in practice due to lower queue overhead. BFS visits vertices level by level while DFS goes deep first.
Analysis
How does graph size affect performance? Both algorithms slow down linearly as vertices and edges increase.
Which is faster? DFS is slightly faster in most experiments.
Do results match O(V + E)? Yes, time grows proportionally to V + E.
When is BFS preferred? When shortest path is needed.
Limitations of DFS? Can get stuck in deep branches, not optimal for shortest path.

E. Screenshots
Add screenshots after running the program:
<img width="1762" height="791" alt="image" src="https://github.com/user-attachments/assets/a42b60f3-25c0-4c41-b853-d0e7c233c031" />
<img width="1777" height="612" alt="image" src="https://github.com/user-attachments/assets/b385f8c3-fd42-4383-95aa-c94cfd8de99b" />


F. Reflection
Implementing this project helped me understand how graphs model real-world relationships such as networks, maps, and social connections. The key insight was that the choice between a queue and a stack completely changes the traversal order. BFS fans out level by level while DFS dives deep into one branch before exploring others.
The biggest challenge was implementing iterative DFS that produces the same order as recursive DFS. Pushing neighbours onto the stack in reverse order solved the problem without adding complexity. Both algorithms share O(V + E) time complexity, but their different traversal paths make each better suited for different problems.
