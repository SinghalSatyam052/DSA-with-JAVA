class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int s = 0,e =0 ;
        int max = 1;
        int curr = nums[0];

        for(int i = 1;i< n;i++){
            e=i;
            while((s<=e) && ((curr & nums[i]) != 0)){
                curr^=nums[s];
                s++;
            }
            curr |= nums[i];
            max = Math.max(max,e-s+1);
        }

        return max;
    }
}