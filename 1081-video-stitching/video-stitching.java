class Solution {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips,(a,b)->a[0]!=b[0]?Integer.compare(a[0],b[0]):Integer.compare(b[1],a[1]));
        int count=0,end=0,i=0,n=clips.length;
        while(end<time){
            int mend=end;
            while(i<n&&clips[i][0]<=end){
                mend=Math.max(mend,clips[i][1]);
                i++;
            }
            if(mend==end){
                return -1;
            }
            end=mend;
            count++;
        }
        return count;
    }
}