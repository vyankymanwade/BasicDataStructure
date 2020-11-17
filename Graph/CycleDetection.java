import java.util.ArrayList;

public class CycleDetection {
    ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();

    public CycleDetection(int v) {
        for (int i = 0; i < v; i++)
            g.add(new ArrayList<>());
    }

    // adding edge for directed graph
    public void addEdgeDirected(int u, int v) {
        g.get(u).add(v);
    }

    public void addEdge(int u, int v) {
        g.get(u).add(v);
        g.get(v).add(u);
    }

    public void print() {
        for (int i = 0; i < g.size(); i++) {
            for (int j = 0; j < g.get(i).size(); j++) {
                System.out.print(g.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public boolean DFSRecursive(boolean visited[], int v, int s, int parent) {
        visited[s] = true;
        for (int u : g.get(s)) {
            if (visited[u] == false) {
                if (DFSRecursive(visited, v, u, s) == true)
                    return true;
            } else if (u != parent)
                return true;
        }
        return false;
    }

    // this is for undirected graph
    public boolean DFS(int v, int s) {
        boolean visited[] = new boolean[v + 1];
        for (int i = 0; i < v; i++) { // this loop is for disconnected graph
            if (visited[i] == false) {
                if (DFSRecursive(visited, v, i, -1) == true)
                    return true;
            }
        }
        return false;
    }

    public boolean DFSDirectedRecursive(boolean visited[], boolean recStack[], int s) {
        visited[s] = true;
        recStack[s] = true;
        for (int u : g.get(s)) {
            if (visited[u] == false) {
                if (DFSDirectedRecursive(visited, recStack, u) == true)
                    return true;
            } else if (recStack[u] == true)
                return true;
        }
        return false;
    }

    public boolean DFSDirected(int v, int s) {
        boolean visited[] = new boolean[v + 1];
        boolean recStack[] = new boolean[v + 1];

        for (int i = 0; i < v; i++) {
            if (visited[i] == false)
                if (DFSDirectedRecursive(visited, recStack, s) == true)
                    return true;
        }
        return false;
    }

    public static void main(String args[]) {
        //undirected graph
        CycleDetection g1 = new CycleDetection(6);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 4);
        g1.addEdge(4, 5);
        g1.addEdge(1, 3);
        g1.addEdge(2, 3);
        g1.print();
        System.out.println("Is Graph Contain Cycle: " + g1.DFS(6, 0));

        // directed graph

        CycleDetection g2 = new CycleDetection(6);
        g2.addEdgeDirected(0, 1);
        g2.addEdgeDirected(2, 1);
        g2.addEdgeDirected(2, 3);
        g2.addEdgeDirected(3, 4);
        g2.addEdgeDirected(4, 5);
        g2.addEdgeDirected(5, 3);
        g2.print();
        System.out.println("Is Directed Graph Contain Cycle: " + g2.DFSDirected(6, 0));
    }
}