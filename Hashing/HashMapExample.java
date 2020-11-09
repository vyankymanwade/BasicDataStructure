import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(101, "Vyanky");
        hm.put(102, "Omkar");
        hm.put(103, "Parth");
        hm.put(104, "Maya");
        hm.put(105, "Omkar");
        hm.put(105, "Kiran");
        System.out.println("after 4 insert: " + hm);
        System.out.println("containsKey(103)" + hm.containsKey(103));
        System.out.println("size() " + hm.size());

        // Traversal of HashMap
        for (Map.Entry<Integer, String> e : hm.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }

        System.out.println("isEmpty(): " + hm.isEmpty());
        System.out.println("hm.entrySet(): " + hm.entrySet());

        System.out.println("get(101): " + hm.get(101)); // => Vyanky
        System.out.println("keySet(): " + hm.keySet()); // returns set of all keys
        System.out.println(hm.remove(101)); // it returns value for key if exists
        System.out.println(hm.remove(107)); // it returns null for key if is not exists
        System.out.println(hm.values()); // returns values from HashMap

        hm.compute(102, (key, val) -> val.concat(" Chougule"));
        System.out.println("after update of omkar :" + hm);
        hm.compute(103, (key, val) -> val = "pa");
        System.out.println("after update of parth :" + hm);
    }
}