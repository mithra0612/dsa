class Solution {
    public int recursion(int[] nums, int idx, int sum, int[][] dp) {
        if (sum == 0) {
            return 1;
        }
        if (idx >= nums.length || sum < 0) {
            return 0;
        }
        if (dp[idx][sum] != -1) {
            return dp[idx][sum];
        }
        int take = recursion(nums, idx + 1, sum - nums[idx], dp);
        int skip = recursion(nums, idx + 1, sum, dp);
        return dp[idx][sum] = (take == 1 || skip == 1) ? 1 : 0;
    }

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum / 2;
        if (sum % 2 != 0)
            return false;

        int[][] dp = new int[nums.length][target + 1];
        for (int[] ar : dp) {
            Arrays.fill(ar, -1);
        }
        int res = recursion(nums, 0, target, dp);
        return res == 1 ? true : false;
    }
}