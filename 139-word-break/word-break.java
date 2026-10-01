class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int maxLen = Integer.MIN_VALUE;
        for(String x : wordDict){
            maxLen = Math.max(x.length(),maxLen);
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=1 ; i <= s.length() ; i++){
            for(int j=1 ; j<= Math.min(i,maxLen) ; j++){
                int start = i-j;
                if(dp[start] && wordDict.contains(s.substring(start,i))){
                    dp[i]= true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}