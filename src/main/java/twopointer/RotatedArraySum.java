package twopointer;

import java.util.Arrays;

public class RotatedArraySum {

//8,9,10,12,22,3,4,6
//
//
//sum =1

    public static void main(String args[]) {
        int[] a = new int[]{8, 9, 10, 12, 22, 3, 4, 6};
        solution(a, 17);
    }

    public static boolean solution(int arr[], int x) {
        int i = 0;
        int n = arr.length;
        for (i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                break;
            }
        }
        int low = (i + 1) % n;
        int high = i;

        while (low != high) {
            if (arr[low] + arr[high] == x) {
                return true;
            }
            if (arr[low] + arr[high] > x) {
                high = (high - 1 + n) % n;
            } else {
                low = (low + 1) % n;
            }
        }
        return false;
    }
}

