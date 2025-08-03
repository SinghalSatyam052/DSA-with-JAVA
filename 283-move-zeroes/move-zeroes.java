class Solution {
    public void moveZeroes(int[] nums) {
        int l = 0, r = 0, n = nums.length;
        while(r<nums.length){
            if(nums[l] != 0){
                l++;
                r++;
            }
            else{
                if(nums[r] != 0){

                    int temp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = temp;
                    l++;
                }
                r++;
            }
        }
    }
}