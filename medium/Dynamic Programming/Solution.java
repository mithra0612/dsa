// question link : https://www.naukri.com/code360/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum_842494

import java.util.*;
public class Solution {

    public static int recursion(int[] arr, int n, int currSum, int remSum,int idx,int[][] dp){
        if(idx >= n){
            return Math.abs(currSum - remSum);
        }
        if(dp[idx][currSum] != -1){
            return dp[idx][currSum];
        }
        int take = recursion(arr,n, currSum + arr[idx], remSum - arr[idx],idx + 1,dp);
        int skip = recursion(arr,n, currSum , remSum ,idx + 1,dp);
        return dp[idx][currSum] = Math.min(take,skip);
    } 
    public static int minSubsetSumDifference(int []arr, int n) {
        int total = 0;
        for(int i = 0; i < n; i++){
            total += arr[i];
        }
        int[][] dp = new int[n][total];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i],-1);
        }
        return recursion(arr,n,0,total,0,dp);
    }
}