class Solution {
    public boolean canJump(int[] nums) {
        int lgoodindex=nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            if(i+nums[i]>=lgoodindex){
                lgoodindex=i;
            }
        }
        return lgoodindex==0;
    }
}