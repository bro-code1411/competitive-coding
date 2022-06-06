package algo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class JobSchedule {
    class The_Comparator implements Comparator<ArrayList<Integer>> {
        public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
            return list1.get(0) - list2.get(0);
        }
    }

    private long findMaxProfit(List<List<Long>> jobs) {
        int n = jobs.size();
        long maxProfit = 0;
        // min heap having {endTime, profit}
        PriorityQueue<ArrayList<Long>> pq = new PriorityQueue<>(new The_Comparator());

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

    public long jobScheduling(List<Long> pickup, List<Long> drop, List<Long> tip) {
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