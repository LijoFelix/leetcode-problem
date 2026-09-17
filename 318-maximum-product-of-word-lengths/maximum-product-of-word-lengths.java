class Solution {
    public int maxProduct(String[] words) {
        int n=words.length;
        int[] nums=new int[n];
        int[] lengths=new int[n];
        for(int i=0;i<n;i++){
            int m=0;
            for(char c:words[i].toCharArray()){
                m|=(1<<(c-'a'));
            }
            nums[i]=m;
            lengths[i]=words[i].length();
        }
        int mprod=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((nums[i]&nums[j])==0){
                    mprod=Math.max(mprod,lengths[i]*lengths[j]);
                }
            }
        }
        return mprod;
    }
}