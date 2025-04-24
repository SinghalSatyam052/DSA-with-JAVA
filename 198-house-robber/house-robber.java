class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return MaxSum(n-1,nums,dp);
    }

    private int MaxSum(int idx, int[] arr,int[] dp){
        if(idx < 0) return 0;
        if(idx == 0) return arr[0];
        
        if(dp[idx] != -1 ) return dp[idx];
        
        if(idx == 0) return dp[0] = arr[0];
        
        return dp[idx] = Math.max(arr[idx] + MaxSum(idx-2,arr,dp),MaxSum(idx-1, arr,dp));
    }
}
