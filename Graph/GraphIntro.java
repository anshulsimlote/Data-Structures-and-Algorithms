package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphIntro {
    // Make Node a static inner class
    static class Node {
        private int destination;
        private int weight;

        public Node(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    /* Graph Representation (Image in comments)
         *  
         *       1 ---(4)--- 2 -------
         *        |         /         |
         *       (1)     (2)          (2)
         *        |     /             |
         *        ------3 -----(4)----5
         *
         *  This represents the following edges:
         *    - Node 1 to Node 2 with weight 4
         *    - Node 1 to Node 3 with weight 1
         *    - Node 2 to Node 3 with weight 2
         *    - Node 2 to Node 5 with weight 2
         *    - Node 3 to Node 5 with weight 4
         */

    public static void main(String[] args) {
        System.out.println("Graph Intro");
        int numberOfNodes = 5;
        ArrayList<ArrayList<Node>> adjacencyList = new ArrayList<>(numberOfNodes + 1);

        // Initialize the adjacency list
        for (int i = 0; i <= numberOfNodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Create the graph
        GraphIntro graph = new GraphIntro();
        graph.createGraph(adjacencyList);

        // Display the graph to verify its structure
        graph.displayGraph(adjacencyList);

        // Perform BFS traversal from node 1
        System.out.println("\nBFS traversal starting from node 1:");
        graph.breadthFirstSearch(adjacencyList, 1);

        // Perform DFS traversal from node 1
        System.out.println("\nDFS traversal starting from node 1:");
        graph.depthFirstSearch(adjacencyList, 1);
    }

    public void createGraph(ArrayList<ArrayList<Node>> adjacencyList) {
        // Adding edges based on the comment above
        adjacencyList.get(1).add(new Node(2, 4));
        adjacencyList.get(2).add(new Node(1, 4));
        adjacencyList.get(2).add(new Node(5, 2));
        adjacencyList.get(5).add(new Node(2, 2));
        adjacencyList.get(5).add(new Node(3, 4));
        adjacencyList.get(3).add(new Node(5, 4));
        adjacencyList.get(1).add(new Node(3, 1));
        adjacencyList.get(3).add(new Node(1, 1));
        adjacencyList.get(2).add(new Node(3, 2));
        adjacencyList.get(3).add(new Node(2, 2));
    }

    // Method to display the adjacency list for verification
    public void displayGraph(ArrayList<ArrayList<Node>> adjacencyList) {
        for (int i = 1; i < adjacencyList.size(); i++) {
            System.out.print("Node " + i + " has edges to: ");
            for (Node node : adjacencyList.get(i)) {
                System.out.print("(" + node.destination + ", " + node.weight + ") ");
            }
            System.out.println();
        }
    }

    // Breadth-First Search algorithm to traverse the graph from a given source
    public void breadthFirstSearch(ArrayList<ArrayList<Node>> adjacencyList, int source) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adjacencyList.size()];

        // Mark the source node as visited and enqueue it
        visited[source] = true;
        queue.add(source);

        // BFS traversal loop
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(curr + " -> ");

            // Visit all adjacent nodes of the current node
            for (Node neighbor : adjacencyList.get(curr)) {
                int dest = neighbor.destination;
                if (!visited[dest]) {
                    visited[dest] = true;
                    queue.add(dest);
                }
            }
        }
        System.out.println("null");  // Indicate the end of traversal
    }

    // Depth-First Search algorithm to traverse the graph from a given source
    public void depthFirstSearch(ArrayList<ArrayList<Node>> adjacencyList, int source) {
        boolean[] visited = new boolean[adjacencyList.size()];
        depthFirstSearchRec(adjacencyList, visited, source);
        System.out.println("null");  // Indicate the end of traversal
    }

    // Recursive helper for DFS
    public void depthFirstSearchRec(ArrayList<ArrayList<Node>> adjacencyList, boolean[] visited, int source) {
        visited[source] = true;
        System.out.print(source + " -> ");
        for (Node tempNode : adjacencyList.get(source)) {
            int dest = tempNode.destination;
            if (!visited[dest]) {
                depthFirstSearchRec(adjacencyList, visited, dest);
            }
        }
    }
}
