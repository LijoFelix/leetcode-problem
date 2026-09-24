class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wset=new HashSet<>(wordDict);
        List<String> ans=new ArrayList<>();
        backtrack(s,0,wset,new ArrayList<>(),ans);
        return ans;
    }
    private void backtrack(String s,int st,Set<String> wset,List<String> cpath,List<String> ans){
        if(st==s.length()){
            ans.add(String.join(" ",cpath));
            return;
        }
        for(int end=st+1;end<=s.length();end++){
            String word=s.substring(st,end);
            if(wset.contains(word)){
                cpath.add(word);
                backtrack(s,end,wset,cpath,ans);
                cpath.remove(cpath.size()-1);
            }
        }
    }
}