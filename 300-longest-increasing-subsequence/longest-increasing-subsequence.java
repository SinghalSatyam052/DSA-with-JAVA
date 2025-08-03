class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        Integer[] lis = new Integer[n];

        int ans = 1;
        for(int i=1;i<n;i++){
            ans = Math.max(lisEndAtIdx(nums, i, lis), ans);
        }
        return ans;
    }

    public int lisEndAtIdx(int[] nums, int i, Integer[] lis){
        if(i == 0) return 1;
        if(lis[i] != null) return lis[i];

        int len = 1;
        for(int prev = 0; prev < i; prev++){
            if(nums[prev] < nums[i]){
                len = Math.max(len, lisEndAtIdx(nums, prev, lis)  + 1);
            }
        }
        return lis[i] = len;
    }
}