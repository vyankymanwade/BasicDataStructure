import java.lang.*;
import java.lang.reflect.Array;
import java.util.*;

class Two {
    int a;
    int b;

    public Two(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public String toString() {
        return this.a + " " + this.b;
    }
}

class sortByA implements Comparator<Two> {
    public int compare(Two t1, Two t2) {
        return t1.a - t2.a;
    }
}

class Sort {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        Two two[] = { new Two(1, 2), new Two(6, 5), new Two(3, 4) };
        Arrays.sort(two, new sortByA());
        System.out.println(Arrays.toString(two));
    }
}