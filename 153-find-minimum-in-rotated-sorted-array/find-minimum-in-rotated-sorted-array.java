class Solution {
    public int findMin(int[] nums) {
        int l=0, r= nums.length-1, min = nums[0];
        while(l<r){
            int mid = (l+r)/2;
            if(nums[r] > nums[mid]) r = mid;
            else l = mid+1;
            
        }
        return nums[l];
    }
}