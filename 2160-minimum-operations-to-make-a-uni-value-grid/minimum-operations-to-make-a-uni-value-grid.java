class Solution {
    public int minOperations(int[][] grid, int x) {
        int[] arr = new int[grid.length * grid[0].length];
        int k =0;
        for(int[] i : grid){
            for(int j: i){
                arr[k] = j;
                k++;
            }
        }
        Arrays.sort(arr);

        int mid = (int)((grid.length * grid[0].length)/2);
        int target = arr[mid];
        int rem = arr[0]%x;
        for(int i:arr) if(i%x != rem) return -1;

        int opCnt = 0;

        for(int i:arr) opCnt+=(Math.abs(i-target))/x;

        return opCnt;
    }
}