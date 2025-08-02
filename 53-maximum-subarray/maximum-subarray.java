class Solution {
    public int maxSubArray(int[] nums) {
        Integer[] dp = new Integer[nums.length+1];
        int[] maxGlobal = new int[]{nums[0]};

        Sum(nums.length-1,nums,dp,maxGlobal);

        return maxGlobal[0];
    }

    public int Sum(int idx, int[] nums, Integer[] dp, int[] maxGlobal){
        if(idx < 0) return 0;
        if(idx == 0) return dp[idx] = nums[idx];

        
        int prev = Sum(idx - 1, nums, dp, maxGlobal);
        int take = Math.max(nums[idx], nums[idx] + prev);
        int notTake = nums[idx];

        maxGlobal[0] = Math.max(maxGlobal[0], take);

        return dp[idx] = Math.max(take,notTake);
    }
}