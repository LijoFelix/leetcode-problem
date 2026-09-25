class Solution {
    public int jump(int[] nums) {
        int tstep=0,cov=0,lindex=0;
        int des=nums.length-1;
        if(nums.length==1){
            return 0;
        }
        for(int i=0;i<nums.length;i++){
            cov=Math.max(cov,i+nums[i]);
            if(i==lindex){
                lindex=cov;
                tstep++;
                if(cov>=des){
                    return tstep;
                }
            }
        }
        return tstep;
    }
}