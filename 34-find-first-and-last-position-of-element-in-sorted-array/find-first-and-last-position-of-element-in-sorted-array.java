class Solution {
    public int[] searchRange(int[] nums, int target) {    
        int len = nums.length;
        int lo = 0, hi = len-1;

        int[] ans = {-1,-1};

        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(nums[mid] == target){
                ans[0] = mid;
                break;
            }
            else if(nums[mid]>target) hi = mid-1;
            else lo = mid+1;
        }

        if(ans[0] != -1){
            ans[1] = ans[0];
            while(ans[0]>0 && nums[ans[0]] == nums[ans[0]-1] ) ans[0] = ans[0]-1;
            while(ans[1]<len-1 && nums[ans[1]] == nums[ans[1]+1] ) ans[1] = ans[1]+1;
        }

        return ans;
    }
}