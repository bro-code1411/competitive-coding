package algo;

import java.util.*;

class JobSchedule {
    public static void main(String[] args) {
        List<Long>pickup=new ArrayList<>(Arrays.asList(0L,2L,9L,10L,11L,12L)) ;
        List<Long>drop=new ArrayList<>(Arrays.asList(5L,9L,11L,11L,14L,17L)) ;
        List<Long>tip=new ArrayList<>(Arrays.asList(1L,2L,3L,2L,2L,1L)) ;

        System.out.println(maxTaxiEarningsSplit(pickup,drop,tip));
    }

    static class Comp implements Comparator<ArrayList<Long>> {
        public int compare(ArrayList<Long> list1, ArrayList<Long> list2) {
            return (int) (list1.get(0) - list2.get(0));
        }
    }

    private static long findMaxProfit(List<List<Long>> jobs) {
        int n = jobs.size();
        long maxProfit = 0;
        // min heap having {endTime, profit}
        PriorityQueue<ArrayList<Long>> pq = new PriorityQueue<>(new Comp());

        for (int i = 0; i < n; i++) {
            long start = jobs.get(i).get(0), end = jobs.get(i).get(1), profit = jobs.get(i).get(2);

            // keep popping while the heap is not empty and
            // jobs are not conflicting
            // update the value of maxProfit
            while (pq.isEmpty() == false && start >= pq.peek().get(0)) {
                maxProfit = Math.max(maxProfit, pq.peek().get(1));
                pq.remove();
            }

            ArrayList<Long> combinedJob = new ArrayList<>();
            combinedJob.add(end);
            combinedJob.add(profit + maxProfit);

            // push the job with combined profit
            // if no non-conflicting job is present maxProfit will be 0
            pq.add(combinedJob);
        }

        // update the value of maxProfit by comparing with
        // profit of jobs that exits in the heap
        while (pq.isEmpty() == false) {
            maxProfit = Math.max(maxProfit, pq.peek().get(1));
            pq.remove();
        }

        return maxProfit;
    }

    public static long maxTaxiEarningsSplit(List<Long> pickup, List<Long> drop, List<Long> tip) {
        List<List<Long>> jobs = new ArrayList<>();

        // storing job's details into one list
        // this will help in sorting the jobs while maintaining the other parameters
        int length = tip.size();

        for (int i = 0; i < length; i++) {
            ArrayList<Long> currJob = new ArrayList<>();
            currJob.add(pickup.get(i));
            currJob.add(drop.get(i));
            currJob.add(drop.get(i) -pickup.get(i)+tip.get(i));

            jobs.add(currJob);
        }

        jobs.sort(Comparator.comparingLong(a -> a.get(0)));
        return findMaxProfit(jobs);
    }
}