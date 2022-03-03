package dp;

import javafx.util.Pair;

import java.util.ArrayList;

import java.util.List;

class TaxiProfit {
    public static void main(String[] args) {
        int[][] rides = {{2,5,6},{0,4,1},{2,5,4}};
        int [][]rides2 = {{0,5,1},{2,9,2},{9,11,3},{10,11,2},{11,14,2},{12,17,1}};
        System.out.println(maxTaxiEarnings(5, rides));
        System.out.println(maxTaxiEarnings(17,rides2));

        int []pickup= {0,2,9,10,11,12};
        int []drop=   {5,9,11,11,14,17};
        int[] tip=    {1,2,3,2,2,1};
        System.out.println(maxTaxiEarningsSplit(new int[]{2,0,2},new int[]{5,4,5},new int[]{2,5,4}));
        System.out.println(maxTaxiEarningsSplit(pickup,drop,tip));
    }

    public static long maxTaxiEarnings(int n, int[][] rides) {
        List<Pair<Integer, Integer>>[] startToEndAndEarns = new List[n];
        // dp[i] := max dollars you can earn starting at i
        long[] dp = new long[n + 1];

        for (int i = 0; i < n; i++)
            startToEndAndEarns[i] = new ArrayList<>();

        for (int[] ride : rides) {
            final int start = ride[0];
            final int end = ride[1];
            final int tip = ride[2];
            final int earn = end - start + tip;
            startToEndAndEarns[start].add(new Pair<>(end, earn));
        }

        for (int i = n - 1; i >= 0; --i) {
            dp[i] = dp[i + 1];
            for (var pair : startToEndAndEarns[i]) {
                final int end = pair.getKey();
                final int earn = pair.getValue();
                dp[i] = Math.max(dp[i], dp[end] + earn);
            }
        }

        return dp[0];
    }

    public static long maxTaxiEarningsSplit(int[] pickup, int[]drop, int[]tip) {
        int maxDrop = 0;
        for (int i = 0; i < drop.length; i++) {
            maxDrop = maxDrop > drop[i] ? maxDrop : drop[i];
        }
        List<Pair<Integer, Integer>>[] startToEndAndEarns = new List[maxDrop];
        for (int i = 0; i < maxDrop; i++)
            startToEndAndEarns[i] = new ArrayList<>();

        for (int i=0 ; i<pickup.length ;i++) {
            final int start = pickup[i];
            final int end = drop[i];
            final int profit = tip[i];
            final int earn = end - start + profit;
            startToEndAndEarns[start].add(new Pair<>(end, earn));
        }

        // dp[i] := max dollars you can earn starting at i
        long[] dp = new long[maxDrop + 1];

        for (int i = maxDrop - 1; i >= 0; --i) {
            dp[i] = dp[i + 1];
            for (var pair : startToEndAndEarns[i]) {
                final int end = pair.getKey();
                final int earn = pair.getValue();
                dp[i] = Math.max(dp[i], dp[end] + earn);
            }
        }
        return dp[0];
    }
};