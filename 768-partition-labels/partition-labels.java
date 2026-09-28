class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans=new ArrayList<>();
        int[] freq=new int[26];
        int st=0,end=0;
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']=i;
        }
        for(int i=0;i<s.length();i++){
            end=Math.max(end,freq[s.charAt(i)-'a']);
            if(i==end){
                ans.add(end-st+1);
                st=i+1;
            }
        }
        return ans;
    }
}