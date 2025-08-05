class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for(int mask=0;mask<(1<<n);mask++){
            int curr = 0;
            for(int j=0;j<n;j++){
                if((mask&(1<<j)) != 0) curr ^= nums[j];
            }
            ans += curr;
        }
        return ans;
    }
}