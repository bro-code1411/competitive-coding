package stack;


class CornerK {

    // Function to return maximum sum
    public static int maxPointCount(int arr[], int K, int size)
    {
        // Initialize variables
        int cur = 0;
        int max = 0;
        // Iterate over first K elements of array and update
        // the value for curr_points
        for (int i = 0; i < K; i++)
            cur += arr[i];
        // Update value for max_points
        max = cur;
        // j points to the end of the array
        for (int i = K - 1, j = size - 1; i >= 0; i--,j--) {
            cur = cur + arr[j] - arr[i];
            max = Math.max(cur, max);
        }
        // Return the final result
        return max;
    }

    // Driver code
    public static void main(String args[])
    {
        int[] arr = { 8, 4, 4, 8, 12, 3, 2, 9 };
        int K = 3;
        int n = arr.length;
        System.out.print(maxPointCount(arr, K, n));
    }
}