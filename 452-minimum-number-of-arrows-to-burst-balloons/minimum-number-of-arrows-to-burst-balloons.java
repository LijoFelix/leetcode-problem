class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b)-> Integer.compare(a[1],b[1]));

        int arrow = 0;

        long end = Long.MIN_VALUE;

        for(int [] balloon : points){
            if(balloon[0]>end){
                arrow++;
                end=balloon[1];
            }
        }
        return arrow;
    }
}