class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1,r=0;
        for(int pile:piles){
            r=Math.max(r,pile);
        }
        while(l<=r){
            int mid=l+(r-l)/2;
            long height=0;
            for(int pile:piles){
                height+=(pile+mid-1)/mid;
            }
            if(height<=h){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
}