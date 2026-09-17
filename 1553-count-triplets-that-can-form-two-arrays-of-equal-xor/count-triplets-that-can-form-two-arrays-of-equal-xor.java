class Solution {
    public int countTriplets(int[] arr) {
        int c=0,n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j;k<n;k++){
                    int a=0,b=0;
                for(int x=i;x<j;x++){
                    a=a^arr[x];
                }
                for(int x=j;x<=k;x++){
                    b=b^arr[x];
                }
                if(a==b){
                    c++;
                }
                }
            }
        }
        return c;
    }
}