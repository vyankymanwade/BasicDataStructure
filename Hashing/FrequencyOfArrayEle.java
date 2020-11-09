/*
    Count frequency of array element
    ip = {10,12,10,15,12,20,12,12}
    op = 10 3
         12 3
         15 1
         20 1

    ip = {5,5,10,510,12,12}
    op = 5 3
         10 2
         12 2
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class FrequencyOfArrayEle {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> al = new ArrayList<>(); // used for maintainig order of accurance BUT WE CAN ALSO DO IT BY
                                                   // USING LinkedHashSet
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (!hm.containsKey(temp)) {
                hm.put(temp, 1);
                al.add(temp);
            } else {
                hm.compute(temp, (key, val) -> val = val + 1);
            }
        }
        for (int e : al) {
            System.out.println(e + " " + hm.get(e));
        }
    }
}