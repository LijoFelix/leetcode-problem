class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int l=0,r=nums[n-1]-nums[0];
        while(l<r){
            int mid=l+(r-l)/2;
            if(smallest(nums,k,mid)){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    boolean smallest(int[] nums,int k,int mid){
        int count=0,left=0;
        for(int right=1;right<nums.length;right++){
            while(nums[right]-nums[left]>mid){
                left++;
            }
            count+=right-left;
        }
        return count>=k;
    }
}