class Solution {
    Set<Integer> visited = new HashSet<>();

    public boolean canCross(int[] stones) {
        int n = stones.length;

        if(n ==1) return true;

        int k = stones[1]-stones[0];


        if(k!= 1) return false;

        return crossHelper(1,1,stones);
    }

    public boolean crossHelper(int curr, int k, int[] stones){

        int key = curr*100000 + k;

        if(visited.contains(key)) return false;
        if(curr == stones.length-1) return true;

        visited.add(key);

        for(int i = k-1;i<=k+1;i++){
            int idx = Arrays.binarySearch(stones, (stones[curr] + i));
            if(idx >= 0 && crossHelper(idx,i,stones)) return true;
        }

        return false;
    }
}