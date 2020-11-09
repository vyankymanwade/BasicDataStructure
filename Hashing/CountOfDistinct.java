/*
    Count The Distinct Element From Array
    ip = {15,12,13,,12,13,13,18}
    op = 4

    ip = {10,10,10}
    op = 1

    ip = {10,20,30}
    op = 3
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

class Count {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> hs = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int ele = Integer.parseInt(br.readLine());
            hs.add(ele);
        }
        System.out.println(hs.size());
    }
}