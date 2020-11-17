import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*  Kahn's Algorithm for cycle detection in DIRECETD Graph
        This is similar to topological sort only differnce is we are having count variable 
        which is incremented for adjecent node and if not able to process all the node 
        then there is cycle.
*/
class KahnsAlgo {
    ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();
    int inDegree[];

    public KahnsAlgo(int v) {
        inDegree = new int[v + 1];
        for (int i = 0; i < v; i++)
            g.add(new ArrayList<>());
    }

    public void addEdge(int u, int v) {
        g.get(u).add(v);
        inDegree[v]++;
    }

    public boolean isContainCycle(int V) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0)
                q.add(i);
        }
        int count = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0)
                    q.add(v);
                count++;
            }
        }
        return (count != V);
    }

    public static void main(String args[]) {
        KahnsAlgo g1 = new KahnsAlgo(5);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 1);
        g1.addEdge(4, 1);
        System.out.println("Is the graph contain cycle: " + g1.isContainCycle(5));
    }
}