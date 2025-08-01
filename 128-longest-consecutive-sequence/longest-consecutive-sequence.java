class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int maxCnt = 0, cnt = 0;

        for(int i=0;i<nums.length;i++) set.add(nums[i]);

        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]-1)) continue;
            int ele = nums[i];
            while(set.contains(ele)){
                set.remove(ele);
                cnt++;
                ele++;
            }
            maxCnt = Math.max(maxCnt,cnt);
            cnt = 0;
        }

        return maxCnt;
    }
}