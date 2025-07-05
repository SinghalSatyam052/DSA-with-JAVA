class Solution {
    public int minOperations(int[] target, int[] arr) {
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<target.length;i++) hm.put(target[i],i);

        int[] stack = new int[arr.length+1];
        int ans = 0;

        for(int a:arr){
            if(!hm.containsKey(a)) continue;

            int idx = Arrays.binarySearch(stack,0,ans,hm.get(a));
            if(idx<0) idx = -(idx+1);
            stack[idx] = hm.get(a);
            ans = Math.max(ans,idx+1);

        }


        return target.length - ans;
    }
    public int longestCommonSubsequence(int[] target, int[] arr) {
        int n = target.length, m = arr.length;
        int[] prev = new int[m+1];

        for(int i=1;i<=n;i++){
            int x = target[i-1];

            int[] curr = new int[m+1];

            for(int j = 1;j<=m;j++){
                int y = arr[j-1];

                if(x == y) curr[j] = prev[j-1]+1;
                else curr[j] = Math.max(prev[j],curr[j-1]);
            }
            prev = curr;
        }
        return prev[m];
    }
}