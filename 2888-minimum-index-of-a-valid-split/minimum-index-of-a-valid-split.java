class Solution {
    public int minimumIndex(List<Integer> nums) {

        int n = nums.size();
        int vote = 0,x =-1;

        for(int i: nums){
            if(vote==0) x=i;
            if(x==i) vote++;
            else vote--;
        }

        vote=0;

        for(int i: nums) if(x == i) vote++;

        int cnt=0;
        
        for(int i=0;i<n;i++){
            if(nums.get(i)==x) cnt++;
            int leftCnt = vote - cnt;

            if(cnt > ((i+1)/2) && leftCnt > ((n-i-1)/2)) return i;
        }

        return -1;
    }
}