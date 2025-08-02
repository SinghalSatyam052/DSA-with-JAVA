class Solution {
    public int rob(int[] nums) {
        Integer[] dp = new Integer[nums.length + 1];

        return help(nums,nums.length-1,dp);
    }

    public int help(int[] nums, int i, Integer[] dp){
        if(i < 0) return 0;
        if(i == 0) return dp[i] = nums[i];
        if(dp[i] != null) return dp[i];

        int take = nums[i] + help(nums, i-2, dp);
        int notTake = help(nums, i-1, dp);

        return dp[i] = Math.max(take,notTake);
    }
}