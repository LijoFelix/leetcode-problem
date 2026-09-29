class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] digit=String.valueOf(n).toCharArray();
        int mark =digit.length;
        for(int i=digit.length-1;i>0;i--){
            if(digit[i-1]>digit[i]){
                digit[i-1]--;
                mark=i;
            }
        }
        for(int i=mark;i<digit.length;i++){
            digit[i]='9';
        }return Integer.parseInt(new String(digit));
    }
}