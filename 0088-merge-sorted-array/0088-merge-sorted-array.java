class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0) return;
        int j =n-1;
        int i=m-1;
        int k =nums1.length-1;
        while(j>=0&&i>=0){
            if(nums1[i]>=nums2[j]){
                nums1[k] = nums1[i];
                i--;
            } else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        if(j>=0){
            while(k>=0){
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
    }
}