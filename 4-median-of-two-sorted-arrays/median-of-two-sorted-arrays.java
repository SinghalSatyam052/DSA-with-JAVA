class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int k = (n+m)/2;
        int i=0, j=0, m1=0, m2=0;

        for(int cnt=0; cnt<=k; cnt++){
            m2 = m1;
            if(i != n && j != m){
                if(nums1[i] > nums2[j]) m1 = nums2[j++];
                else m1 = nums1[i++];
            }else if(i != n) m1 = nums1[i++];
            else m1 = nums2[j++];
        }

        if(((n+m)&1) != 0) return (double)m1;
        return (double)(m1+m2)/2;
    }
}