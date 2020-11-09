import java.lang.*;
import java.util.*;

class BinarySearch {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int a[] = new int[10];
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        int key = s.nextInt();
        int index = binarySearch(a, n, key);
        if (index == -1) {
            System.out.println("Element not found");
        } else
            System.out.println("eleement at :" + index);
        int index1 = binarySearchRecursive(a, 0, n - 1, key);
        if (index1 == -1) {
            System.out.println("Element not found");
        } else
            System.out.println("eleement at by recursive :" + index1);
    }

    public static int binarySearch(int a[], int n, int key) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == key) {
                return mid;
            }
            if (key > a[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int a[], int low, int high, int key) {
        int mid = (low + high) / 2;
        if (low >= high) {
            return -1;
        }
        if (a[mid] == key) {
            return mid;
        }
        if (key > a[mid]) {
            return binarySearchRecursive(a, mid + 1, high, key);
        } else {
            return binarySearchRecursive(a, low, mid - 1, key);
        }
    }
}