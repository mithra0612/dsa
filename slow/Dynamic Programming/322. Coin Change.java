
// class Solution {
//     public int recursion(int[] coins, int amount, int count, int idx) {
//         if (amount == 0) {
//             return count;
//         }
//         if (amount < 0 || idx >= coins.length) {
//             return Integer.MAX_VALUE;
//         }
//         int take = recursion(coins, amount - coins[idx], count + 1, idx);
//         int skip = recursion(coins, amount, count, idx + 1);
//         return Math.min(take, skip);
//     }

//     public int coinChange(int[] coins, int amount) {
//         int count = recursion(coins, amount, 0, 0);
//         return count != Integer.MAX_VALUE ? count : -1;
//     }
// }

// USING DP MEMOIZATION


class Solution {
    public int recursion(int[] coins, int amount, int idx, int[][] dp) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0 || idx >= coins.length) {
            return Integer.MAX_VALUE;
        }
        if (dp[idx][amount] != -1) {
            return dp[idx][amount];
        }
        int take = recursion(coins, amount - coins[idx], idx, dp);
        if (take != Integer.MAX_VALUE)
            take += 1;
        int skip = recursion(coins, amount, idx + 1, dp);
        return dp[idx][amount] = Math.min(take, skip);
    }

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int count = recursion(coins, amount, 0, dp);
        return count != Integer.MAX_VALUE ? count : -1;
    }
}

/*
Explanation:
This solution uses recursion with memoization (top-down DP) to find the minimum
number of coins needed to make the given amount.

At each step, we have two choices:
1) Take the current coin (stay at same index since coins are unlimited)
2) Skip the current coin and move to the next

We store results in dp[idx][amount] to avoid recomputing subproblems.
If a combination is not possible, we return Integer.MAX_VALUE.
Finally, we return the minimum coins required, or -1 if no solution exists.

Time Complexity:  O(n * amount)
Space Complexity: O(n * amount)
*/
