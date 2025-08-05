class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        int k = r;

        while(l<r){
            int time = 0;
            int mid = (r+l)/2;
            for(int i:piles) time += (i+mid-1)/mid;
            if(time <= h){
                k = mid;
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return k;
    }
}