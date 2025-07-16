class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i:nums) sum+=i;
        if(sum%2 != 0) return false;

        boolean[] dp = new boolean[sum/2 + 1];
        dp[0] = true;

        for(int num:nums){
            for(int currSum = sum/2;currSum>=num;currSum--){
                dp[currSum] = dp[currSum] || dp[currSum - num];
                if(dp[sum/2]) return true;
            }
        }
        return false;

    }
}