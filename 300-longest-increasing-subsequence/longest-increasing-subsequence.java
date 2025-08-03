class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> lis = new ArrayList<>();

        lis.add(Integer.MIN_VALUE);

        for(int i=1;i<=n;i++){
            lis.add(Integer.MAX_VALUE);
        }

        int ans = 0;
        for(int i=0;i<n;i++){

            //lower bound  //first index such that ele at index is greater than the current number
            int idx = Collections.binarySearch(lis, nums[i]);
            if(idx < 0) idx = -(idx+1);

            if(lis.get(idx) == Integer.MAX_VALUE) ans++;
            if(lis.get(idx) > nums[i]) lis.set(idx, nums[i]);
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