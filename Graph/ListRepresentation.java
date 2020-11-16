import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Graph {

    ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();

    public Graph(int v) {
        for (int i = 0; i < v; i++)
            g.add(new ArrayList<Integer>());
    }

    public void addEdge(ArrayList<ArrayList<Integer>> g, int u, int v) {
        g.get(u).add(v);
        g.get(v).add(u);
    }

    public void printGraph(ArrayList<ArrayList<Integer>> g) {
        for (int u = 0; u < g.size(); u++) {
            for (int v = 0; v < g.get(u).size(); v++) {
                System.out.print(g.get(u).get(v) + " ");
            }
            System.out.println();
        }
    }

    // given undirected graph and source vertex and preinting BFS of graph
    public void BFS(ArrayList<ArrayList<Integer>> g, boolean visited[], int n, int s) {
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);
        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");
            for (int v : g.get(u)) {
                if (visited[v] == false) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }

    public void BFSDisconnected(ArrayList<ArrayList<Integer>> g, boolean visited[], int n) {
        for (int i = 0; i < n; i++)
            if (visited[i] == false)
                BFS(g, visited, n, i);
    }

    public int countConnectedCompenent(boolean visited[], int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                BFS(g, visited, n, i);
                count++;
            }
        }
        return count;
    }

    public void DFS(ArrayList<ArrayList<Integer>> g, int v, int s) {
        boolean visited[] = new boolean[v + 1];
        DFSRecursive(g, visited, v, s);
        System.out.println();
    }

    public void DFSRecursive(ArrayList<ArrayList<Integer>> g, boolean visited[], int v, int s) {
        visited[s] = true;
        System.out.print(s + " ");
        for (int u : g.get(s)) {
            if (visited[u] == false)
                DFSRecursive(g, visited, v, u);
        }
    }

    public void DFSDisconnected(ArrayList<ArrayList<Integer>> g, int v, int s) {
        boolean visited[] = new boolean[v + 1];
        for (int i = 0; i < v; i++) {
            if (visited[i] == false)
                DFSRecursive(g, visited, v, i);
        }
        System.out.println();
    }

    public static void main(String args[]) {
        // connected Graph
        Graph g1 = new Graph(5);
        g1.addEdge(g1.g, 0, 1);
        g1.addEdge(g1.g, 0, 2);
        g1.addEdge(g1.g, 1, 2);
        g1.addEdge(g1.g, 1, 3);
        g1.addEdge(g1.g, 2, 4);
        g1.addEdge(g1.g, 2, 3);
        g1.addEdge(g1.g, 3, 4);
        g1.printGraph(g1.g);
        boolean visited[] = new boolean[5 + 1];
        System.out.print("BFS for connected grpah: ");
        g1.BFS(g1.g, visited, 5, 0);

        // Disconnected Graph

        Graph g2 = new Graph(7);
        g2.addEdge(g2.g, 0, 1);
        g2.addEdge(g2.g, 0, 2);
        g2.addEdge(g2.g, 2, 3);
        g2.addEdge(g2.g, 1, 3);
        g2.addEdge(g2.g, 4, 5);
        g2.addEdge(g2.g, 4, 6);
        g2.addEdge(g2.g, 5, 6);
        g2.printGraph(g2.g);
        boolean visited1[] = new boolean[7 + 1];
        System.out.print("BFS for disconnected grpah: ");
        g2.BFSDisconnected(g2.g, visited1, 7);
        boolean visited2[] = new boolean[7 + 1];
        System.out.println();
        System.out.println("connected component: " + g2.countConnectedCompenent(visited2, 7));

        // DFS
        System.out.print("DFS for connected grpah: ");
        g1.DFS(g1.g, 5, 0);

        // DFS for disconnected graph
        System.out.print("DFS for disconnected grpah: ");
        g1.DFSDisconnected(g2.g, 7, 0);
    }
}