package dp;

import org.junit.Test;

public class IncreasingSubsequenceTest {

    @Test
    public void testSubsequence() {
        int arr[] = {12, 8, 11, 13, 10, 15, 14, 16, 20};
        int n = arr.length;
        int k = 4;
        IncreasingSubsequence question = new IncreasingSubsequence();
        assert (question.numOfIncSubseqOfSizeK(arr, n, k) == 39);
    }
}
