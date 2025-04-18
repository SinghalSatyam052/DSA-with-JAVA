class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = nums[0],currMax = nums[0],currMin = nums[0];

        for(int i=1;i<n;i++){
            int temp = currMax;
            currMax = Math.max(nums[i], Math.max(nums[i]*currMax,nums[i]*currMin));
            currMin = Math.min(nums[i], Math.min(nums[i]*currMin,nums[i]*temp));

            max = Math.max(currMax,max);
        }

        
        return max;
    }
}