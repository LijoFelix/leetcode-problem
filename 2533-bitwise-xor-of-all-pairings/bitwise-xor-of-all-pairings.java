class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int res=0,n=nums2.length,m=nums1.length;
        if(n%2!=0){
            for(int num:nums1){
                res^=num;
            }
        }
        if(m%2!=0){
            for(int num:nums2){
                res^=num;
            }
        }
        return res;
    }
}