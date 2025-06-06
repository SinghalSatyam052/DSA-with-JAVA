class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        for(int i=0;i<nums.length-2;i++){
            if(nums[i] == 0){
                ans++;
                nums[i] = 1;
                nums[i+1] = nums[i+1] == 1?0:1;
                nums[i+2] = nums[i+2] == 1?0:1;
            }
        }

        for(int num:nums) if(num == 0) return -1;

        return ans;
    }
}