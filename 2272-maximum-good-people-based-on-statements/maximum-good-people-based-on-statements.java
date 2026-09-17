class Solution {
    public int maximumGood(int[][] statements) {
        int n=statements.length;
        int mgood=0,tscores=1<<n;
        for(int i=0;i<tscores;i++){
            if(valid(i,statements,n)){
                mgood=Math.max(mgood,Integer.bitCount(i));
            }
        }
        return mgood;
    }
    private boolean valid(int mask,int[][] statements,int n){
        for(int i=0;i<n;i++){
            if(((mask>>i)&1)==1){
                for(int j=0;j<n;j++){
                    int statement=statements[i][j];
                    if(statement==2){
                        continue;
                    }
                    int astatus=(mask>>j)&1;
                    if(statement!=astatus){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}