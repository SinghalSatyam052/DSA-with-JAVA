class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int mask = 0;mask<(1<<n);mask++){
            List<Integer> curr = new ArrayList<>();
            for(int j=0;j<n;j++){
                if((mask&(1<<j)) != 0) curr.add(nums[j]);
            }
            ans.add(curr);
        }
        return ans;
    }
}