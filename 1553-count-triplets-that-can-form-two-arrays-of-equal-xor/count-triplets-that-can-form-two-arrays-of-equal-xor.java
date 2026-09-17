class Solution {
    public int countTriplets(int[] arr) {
        int c=0,n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int a=0;
                for(int k=i;k<j;k++){
                    a=a^arr[k];
                }
                int b=0;
                for(int k=j;k<n;k++){
                    b=b^arr[k];
                    if(a==b){
                        c++;
                    }
                }
            }
        }
        return c;
    }
}