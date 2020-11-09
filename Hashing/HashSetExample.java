import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {
    public static void main(String args[]) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> hs = new HashSet<>();
        // add() will returns TRUE after successful insert
        hs.add("Vyankatesh");
        hs.add("Parth");
        hs.add("Omkar");
        hs.add("Shashank");
        hs.add("Maya");
        hs.add("Maya");
        System.out.println("after adding 6 with 1 duplicate : " + hs);
        hs.remove("Maya");
        System.out.println("remove(Maya): " + hs);
        System.out.println("after remove 1 remove: " + hs.size());
        Iterator<String> i = hs.iterator();
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
        System.out.println();
        System.out.println("contains(Vyankatesh) " + hs.contains("Vyankatesh")); // contains will check object is
                                                                                 // present?

        System.out.println("isEmpty() " + hs.isEmpty());

        HashSet<String> hs1 = new HashSet<>();
        // add() will returns TRUE after successful insert
        hs1.add("Vyankatesh");
        hs1.add("Parth");
        hs1.add("Omkar");
        hs1.add("Shashank");
        hs1.add("Maya");
        hs1.add("Maya");
        System.out.println("hs: " + hs);
        System.out.println("hs1: " + hs1);
        System.out.println("hs1 equals(hs) : " + hs1.equals(hs));
        System.out.println("hashcode of hs : " + hs.hashCode());
        System.out.println("hashcode of hs1 :" + hs1.hashCode());
        System.out.println(hs == hs1);
        System.out.println("toString(): " + hs.toString());
        Object abc[] = hs.toArray();
        for (Object a : abc) {
            System.out.print(a + " ");
        }
        System.out.println();
        hs.clear();
        System.out.println(hs);
    }
}
