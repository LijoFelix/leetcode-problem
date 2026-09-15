class Solution {
    public int hammingDistance(int x, int y) {
        int ans=x^y,c=0;
        while(ans!=0){
            c+=ans&1;
            ans=ans>>1;
        }
        return c;
    }
}