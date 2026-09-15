class Solution {
    public int missingNumber(int[] nums) {
        int ans=nums.length,n=nums.length;
        for(int i=0;i<n;i++){
            ans=ans^i^nums[i];
        }
        return ans;
    }
}
