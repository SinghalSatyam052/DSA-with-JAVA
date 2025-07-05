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
}