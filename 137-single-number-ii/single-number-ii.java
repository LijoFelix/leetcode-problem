class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int i=0;i<32;i++){
            int c=0;
            for(int num:nums){
                c+=(num>>i)&1;
            }
            if(c%3!=0){
                ans|=(1<<i);
            }
        }
        return ans;
    }
}