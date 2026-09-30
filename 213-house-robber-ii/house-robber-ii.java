class Solution {
    public int rob(int[] nums) {
        if(nums.length<2){
            return nums[0];
        }
        int [] dp1= new int[nums.length-1];
        int [] dp2= new int[nums.length-1];

        for(int i=0;i<nums.length-1;i++){
            dp1[i]=nums[i];
            dp2[i]=nums[i+1];
        }
    int ans1 = robb(dp1);
    int ans2= robb(dp2);
    return Math.max(ans1, ans2);
}
    private int robb(int[] nums) {
        if(nums.length<2){
            return nums[0];
        }
        int [] dp = new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[nums.length -1];
    }

}