class Solution {
    public int countCompleteDayPairs(int[] hours) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int cnt = 0;

        for(int i=0;i<hours.length;i++){
            int hash = (24-hours[i]%24)%24;
            if(map.containsKey(hash)) cnt+=map.get(hash);

            int rem = hours[i] % 24;
            map.put(rem, map.getOrDefault(rem, 0) + 1);

        }
        return cnt;
    }
}