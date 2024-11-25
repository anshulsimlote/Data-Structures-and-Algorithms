package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycle {
    public static void main(String[] args) {
        System.out.println("Detect Cycle");
        int n = 7;
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Define the graph's edges
        adjacencyList.get(1).add(2);
        adjacencyList.get(1).add(3);

        adjacencyList.get(2).add(5);
        adjacencyList.get(2).add(1);

        adjacencyList.get(3).add(1);
        adjacencyList.get(3).add(6);

        adjacencyList.get(4).add(6);

        adjacencyList.get(5).add(2);
        adjacencyList.get(5).add(7);

        adjacencyList.get(6).add(3);
        adjacencyList.get(6).add(7);
        adjacencyList.get(6).add(4);

        adjacencyList.get(7).add(6);
        adjacencyList.get(7).add(5);

        System.out.println("BFS Traversal and Cycle Detection:");
        boolean[] isVisitedBFS = new boolean[n + 1];
        boolean cycleInBFS = false;

        for (int i = 1; i <= n; i++) {
            if (!isVisitedBFS[i]) {
                if (bfs(adjacencyList, n, i, isVisitedBFS)) {
                    cycleInBFS = true;
                }
            }
        }
        if (cycleInBFS) {
            System.out.println("\nCycle detected in BFS.");
        } else {
            System.out.println("\nNo cycle detected in BFS.");
        }

        System.out.println("\nDFS Traversal and Cycle Detection:");
        boolean[] isVisitedDFS = new boolean[n + 1];
        boolean cycleInDFS = false;

        for (int i = 1; i <= n; i++) {
            if (!isVisitedDFS[i]) {
                if (dfs(adjacencyList, i, -1, isVisitedDFS)) {
                    cycleInDFS = true;
                }
            }
        }
        if (cycleInDFS) {
            System.out.println("\nCycle detected in DFS.");
        } else {
            System.out.println("\nNo cycle detected in DFS.");
        }
    }

    // BFS with proper cycle detection
    public static boolean bfs(ArrayList<ArrayList<Integer>> adjacencyList, int n, int source, boolean[] isVisited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{source, -1}); // Node, Parent
        isVisited[source] = true;

        System.out.print(source + ",");

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int parent = current[1];

            for (int neighbor : adjacencyList.get(node)) {
                if (!isVisited[neighbor]) {
                    System.out.print(neighbor + ",");
                    queue.add(new int[]{neighbor, node});
                    isVisited[neighbor] = true;
                } else if (neighbor != parent) {
                    // Cycle detected
                    System.out.println("\nCycle detected at node: " + neighbor);
                    return true;
                }
            }
        }
        return false;
    }

    // DFS with proper cycle detection
    public static boolean dfs(ArrayList<ArrayList<Integer>> adjacencyList, int node, int parent, boolean[] isVisited) {
        isVisited[node] = true;
        System.out.print(node + ",");

        for (int neighbor : adjacencyList.get(node)) {
            if (!isVisited[neighbor]) {
                if (dfs(adjacencyList, neighbor, node, isVisited)) {
                    return true;
                }
            } else if (neighbor != parent) {
                System.out.println("\nCycle detected at node: " + neighbor);
                return true;
            }
        }
        return false;
    }
}
