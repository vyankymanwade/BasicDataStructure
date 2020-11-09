import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

public class Sort {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Vector<Integer> v = new Vector<Integer>(n);
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());
            v.add(val);
        }
        recursionSort(v);
        System.out.println(v);
    }

    public static void recursionSort(Vector<Integer> v) {
        if (v.size() == 1)
            return;
        int temp = v.get(v.size() - 1);
        v.remove(v.size() - 1);
        recursionSort(v);
        insert(v, temp);
    }

    public static void insert(Vector<Integer> v, int temp) {
        if (v.size() == 0 || v.get(v.size() - 1) <= temp) {
            v.add(temp);
            return;
        }
        int last = v.lastElement();
        v.remove(v.size() - 1);
        insert(v, temp);
        v.add(last);
    }
}