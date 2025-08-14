class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        Integer[] dp = new Integer[n];

        return solve(nums, 0, dp);
    }

    public int solve(int[] nums, int idx, Integer[] dp){
        int n = nums.length;
        if(idx >= n-1) return 0;
        if(nums[idx] == 0) return Integer.MAX_VALUE;
        if(dp[idx] != null) return dp[idx];

        int min = Integer.MAX_VALUE;
        for(int i=1; i<=nums[idx]; i++){
            if(idx + i >= n) break;
            int next = solve(nums, idx + i, dp);
            if(next != Integer.MAX_VALUE) {
                min = Math.min(min, 1+ next);
            }
        }

        return dp[idx] = min;
    }
}
