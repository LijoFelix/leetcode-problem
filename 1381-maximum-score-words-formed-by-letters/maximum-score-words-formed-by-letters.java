class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] lcount=new int[26];
        for(char c:letters){
            lcount[c-'a']++;
        }
        int n=words.length;
        int mscore=0;
        for(int m=0;m<(1<<n);m++){
            int[] ccount=new int[26];
            boolean flag=true;
            int cscore=0;
            for(int i=0;i<n;i++){
                if((m&(1<<i))!=0){
                    for(char c:words[i].toCharArray()){
                        int index=c-'a';
                        ccount[index]++;
                        cscore+=score[index];
                        if(ccount[index]>lcount[index]){
                            flag=false;
                            break;
                        }
                    }
                }
                if(!flag){
                    break;
                }
            }
            if(flag){
                mscore=Math.max(mscore,cscore);
            }

        }
        return mscore;
    }
}