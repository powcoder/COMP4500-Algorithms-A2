https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
package assignment2;

public class Dynamic {

    // Method to find the total cost of an optimal valid roster using a bottom-up dynamic programming approach
    public static int optimalDynamic(int k, int[] work, Recursive.Worker w0, Recursive.Worker w1) {
        // Create a 3D array to store the minimum cost for each day and each combination of workers
        int[][][] dp = new int[k + 1][2][2];

        // Initialize the base case (when k is 0)
        dp[0][0][0] = 0;

        // Fill the dp array in a bottom-up manner
        for (int i = 1; i <= k; i++) {
            // Consider all possible combinations of workers for the current day
            for (int j = 0; j < 2; j++) {
                for (int l = 0; l < 2; l++) {
                    dp[i][j][l] = Integer.MAX_VALUE;
                    // Case 1: Only w0 works on the current day
                    if (isValidSchedule(work, w0, w1, i - 1, new int[]{j, l}) && j == 1) {
                        dp[i][j][l] = Math.min(dp[i][j][l], w0.cost(i - 1) + max(0, work[i - 1] - w0.capacity(i - 1))
                                + dp[i - 1][0][l]);
                    }
                    // Case 2: Only w1 works on the current day
                    if (isValidSchedule(work, w0, w1, i - 1, new int[]{j, l}) && l == 1) {
                        dp[i][j][l] = Math.min(dp[i][j][l], w1.cost(i - 1) + max(0, work[i - 1] - w1.capacity(i - 1))
                                + dp[i - 1][j][0]);
                    }
                    // Case 3: Both w0 and w1 work on the current day
                    if (isValidSchedule(work, w0, w1, i - 1, new int[]{j, l}) && j == 1 && l == 1) {
                        dp[i][j][l] = Math.min(dp[i][j][l], w0.cost(i - 1) + w1.cost(i - 1) + max(0, work[i - 1] - (w0.capacity(i - 1) + w1.capacity(i - 1)))
                                + dp[i - 1][0][0]);
                    }
                    // Case 4: Neither w0 nor w1 works on the current day
                    if (isValidSchedule(work, w0, w1, i - 1, new int[]{j, l}) && j == 0 && l == 0) {
                        dp[i][j][l] = Math.min(dp[i][j][l], max(0, work[i - 1]) + dp[i - 1][0][0]);
                    }
                }
            }
        }

        // The minimum cost will be in the last cell of the dp array
        return Math.min(Math.min(dp[k][0][0], dp[k][0][1]), Math.min(dp[k][1][0], dp[k][1][1]));
    }

    // Method to find a valid roster with the least cost using a bottom-up dynamic programming approach
    public static int[] optimalSolutionDynamic(int k, int[] work, Recursive.Worker w0, Recursive.Worker w1) {
        // Create a 3D array to store the minimum cost for each day and each combination of workers
        int[][][] dp = new int[k + 1][2][2];
        // Create a 3D array to store the optimal schedule for each day and each combination of workers
        int[][][] schedule = new int[k + 1][2][2][2];

        // Initialize the base case (when k is 0)
        dp[0][0][0] = 0;

        // Fill the dp and schedule arrays in a bottom-up manner
        for (int i = 1; i <= k; i++) {
            // Consider all possible combinations of workers for the current day
            for (int j = 0; j < 2; j++) {
                for (int l = 0; l < 2; l++) {
                    dp[i][j][l] = Integer.MAX_VALUE;
                    // Case 1: Only w0 works on the current day
                    if (isValidSchedule(work, w0, w1, i - 1, new int[]{j, l}) && j == 1) {
                        if (w0.cost(i - 1) + max(0, work[i - 1] - w0.capacity(i - 1))
                                + dp[i - 1][0][l] < dp[i][j][l]) {
                            dp[i][j][l] = w0.cost(i - 1) + max(0, work[i - 1] - w0.capacity(i - 1))
                                    + dp[i - 1][0][l];
                            schedule[i][j][l][0] = 1;
                            schedule[i][j][l][1] = 0;
                        }
                    }
                    // Case 2: Only w1 works on the current day
                    if (isValidSchedule(work, w0, w1, i - 1, new int[]{j, l}) && l == 1) {
                        if (w1.cost(i - 1) + max(0, work[i - 1] - w1.capacity(i - 1))
                                + dp[i - 1][j][0] < dp[i][j][l]) {
                            dp[i][j][l] = w1.cost(i - 1) + max(0, work[i - 1] - w1.capacity(i - 1))
                                    + dp[i - 1][j][0];
                            schedule[i][j][l][0] = 0;
                            schedule[i][j][l][1] = 1;
                        }
                    }
                    // Case 3: Both w0 and w1 work on the current day
                    if (isValidSchedule(work, w0, w1, i - 1, new int[]{j, l}) && j == 1 && l == 1) {
                        if (w0.cost(i - 1) + w1.cost(i - 1) + max(0, work[i - 1] - (w0.capacity(i - 1) + w1.capacity(i - 1)))
                                + dp[i - 1][0][0] < dp[i][j][l]) {
                            dp[i][j][l] = w0.cost(i - 1) + w1.cost(i - 1) + max(0, work[i - 1] - (w0.capacity(i - 1) + w1.capacity(i - 1)))
                                    + dp[i - 1][0][0];
                            schedule[i][j][l][0] = 1;
                            schedule[i][j][l][1] = 1;
                        }
                    }
                    // Case 4: Neither w0 nor w1 works on the current day
                    if (isValidSchedule(work, w0, w1, i - 1, new int[]{j, l}) && j == 0 && l == 0) {
                        if (max(0, work[i - 1]) + dp[i - 1][0][0] < dp[i][j][l]) {
                            dp[i][j][l] = max(0, work[i - 1]) + dp[i - 1][0][0];
                            schedule[i][j][l][0] = 0;
                            schedule[i][j][l][1] = 0;
                        }
                    }
                }
            }
        }

        // Find the optimal schedule from the schedule array
        int[] optimalSchedule = new int[k];
        int minCostIndex = findMinCostIndex(dp[k]);
        int[] minCostIndices = getIndices(minCostIndex);
        for (int i = k; i > 0; i--) {
            optimalSchedule[i - 1] = schedule[i][minCostIndices[0]][minCostIndices[1]][0] * 2 + schedule[i][minCostIndices[0]][minCostIndices[1]][1];
            minCostIndex = findMinCostIndex(dp[i - 1]);
            minCostIndices = getIndices(minCostIndex);
        }

        return optimalSchedule;
    }

    private static boolean isValidSchedule(int[] work, Recursive.Worker w0, Recursive.Worker w1, int day, int[] schedule) {
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

    private static int findMinCostIndex(int[][] dp) {
        int minCost = Integer.MAX_VALUE;
        int minCostIndex = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (dp[i][j] < minCost) {
                    minCost = dp[i][j];
                    minCostIndex = i * 2 + j;
                }
            }
        }
        return minCostIndex;
    }

    private static int[] getIndices(int index) {
        return new int[]{index / 2, index % 2};
    }
}
