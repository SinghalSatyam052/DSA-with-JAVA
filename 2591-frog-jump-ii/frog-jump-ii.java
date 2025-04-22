class Solution {
    public int maxJump(int[] stones) {
        int min = stones[1],n=stones.length;
        for(int i=0;i<n-2;i++){
            int diff = stones[i]-stones[i+2];
            min = Math.max(min,Math.abs(diff));
        }
        return min;
    }
}