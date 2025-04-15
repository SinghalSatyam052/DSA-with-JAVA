class Solution {
    public int binSear(int[] nums,int target,boolean isFirst){
        int res = -1;
        int lo = 0;
        int hi = nums.length-1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;

            if(nums[mid] == target){
                res= mid;
                if(isFirst) hi = mid-1;
                else lo = mid+1;
            }
            else if(nums[mid]>target) hi = mid-1;
            else lo = mid+1;
        }
        return res;
    }
    public int[] searchRange(int[] nums, int target) {    
        
        int[] ans = {-1,-1};

        ans[0] = binSear(nums,target,true);

        if(ans[0] != -1) ans[1] = binSear(nums,target,false);

        return ans;
    }
}