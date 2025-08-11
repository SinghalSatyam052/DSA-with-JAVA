class Solution {
    public int findKthLargest(int[] nums, int k) {
        Map<Integer,Integer> hm = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i=0;i<n;i++){
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
            max = Math.max(max,nums[i]);
        }

        if(hm.size() == 1) return max;

        k-=hm.get(max);
        while(k>0){
            max--;
            if(hm.containsKey(max)) k-=hm.get(max);
        }

        return max;
    }
}