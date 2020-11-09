import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

class Chaining {

    private List<Integer>[] ll;
    private int BUCKET;

    public Chaining(int n) {
        BUCKET = n;
        ll = new List[BUCKET];
    }

    public int hash(int key) {
        return (key % BUCKET);
    }

    public boolean search(int key) {
        int i = hash(key);
        for (int x : ll[i]) {
            if (key == x)
                return true;
        }
        return false;
    }

    public void insert(int key) {
        int i = hash(key);
        ll[i].add(key);
    }

    public void delete(int key) {
        int i = hash(key);
        ll[i].remove(key);
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Chaining c = new Chaining(7);
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int val = br.read();
            System.out.println(val);
            c.insert(val);
        }
        System.out.println(c.search(49));
        c.delete(49);
        System.out.println(c.search(49));
    }
}