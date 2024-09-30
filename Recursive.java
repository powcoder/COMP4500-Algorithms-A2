https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
package assignment2;

public class Recursive {

    // Method to find the total cost of an optimal valid roster using a naive recursive approach
    public static int optimalRecursive(int k, int[] work, Worker w0, Worker w1) {
        // Base case: if k is 0, there is no cost
        if (k == 0) {
            return 0;
        }

        // Consider all possible combinations of workers for the current day
        int minCost = Integer.MAX_VALUE;
        // Case 1: Only w0 works on the current day
        if (isValidSchedule(work, w0, w1, k - 1, new int[]{1, 0})) {
            minCost = Math.min(minCost, w0.cost(k - 1) + max(0, work[k - 1] - w0.capacity(k - 1))
                    + optimalRecursive(k - 1, work, w0, w1));
        }
        // Case 2: Only w1 works on the current day
        if (isValidSchedule(work, w0, w1, k - 1, new int[]{0, 1})) {
            minCost = Math.min(minCost, w1.cost(k - 1) + max(0, work[k - 1] - w1.capacity(k - 1))
                    + optimalRecursive(k - 1, work, w0, w1));
        }
        // Case 3: Both w0 and w1 work on the current day
        if (isValidSchedule(work, w0, w1, k - 1, new int[]{1, 1})) {
            minCost = Math.min(minCost, w0.cost(k - 1) + w1.cost(k - 1) + max(0, work[k - 1] - (w0.capacity(k - 1) + w1.capacity(k - 1)))
                    + optimalRecursive(k - 1, work, w0, w1));
        }
        // Case 4: Neither w0 nor w1 works on the current day
        if (isValidSchedule(work, w0, w1, k - 1, new int[]{0, 0})) {
            minCost = Math.min(minCost, max(0, work[k - 1]) + optimalRecursive(k - 1, work, w0, w1));
        }

        return minCost;
    }

    private static boolean isValidSchedule(int[] work, Worker w0, Worker w1, int day, int[] schedule) {
        // Check if the schedule for the current day is valid for both workers
        if (schedule[0] == 1 && (w0.daysWorkedInRow >= w0.maxShift || (day > 0 && schedule[0] == 1 && w0.daysOff < w0.minBreak))) {
            return false;
        }
        if (schedule[1] == 1 && (w1.daysWorkedInRow >= w1.maxShift || (day > 0 && schedule[1] == 1 && w1.daysOff < w1.minBreak))) {
            return false;
        }
        return true;
    }

    private static int max(int a, int b) {
        return a > b? a : b;
    }

    // Inner class to represent a worker
    static class Worker {
        int maxShift;
        int minBreak;
        int[] capacity;
        int[] cost;
        int daysWorkedInRow;
        int daysOff;

        public Worker(int maxShift, int minBreak, int[] capacity, int[] cost) {
            this.maxShift = maxShift;
            this.minBreak = minBreak;
            this.capacity = capacity;
            this.cost = cost;
        }
    }
}
