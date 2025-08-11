class Solution {
    public int[] sortArray(int[] nums) {
        MergeSort(nums,0,nums.length-1);
        return nums;
    }

    private void MergeSort(int[] arr,int p, int r) {
        if(p<r){
            int q = p +(r-p)/2;
            MergeSort(arr, p, q);
            MergeSort(arr, q+1,r);
            Merge(arr, p, q, r);
        }
    }
    private void Merge(int[] arr, int p, int q, int r) {
        int n1 = q-p+1, n2 = r-q;
        int[] L = new int[n1+1];
        int[] R = new int[n2+1];
        for (int i = 0; i < n1; i++) {
            L[i] = arr[p + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[q + j + 1];
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        int i=0,j=0;
        for(int k = p;k<=r;k++){
            if(L[i]<=R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            
        }
    }
}