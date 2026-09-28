class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 1;
        int right = 10000000;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canArrive(dist, hour, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean canArrive(int[] dist, double hour, int speed) {
        double totalTime = 0.0;
        for (int i = 0; i < dist.length - 1; i++) {
            totalTime += Math.ceil((double) dist[i] / speed);
        }
        totalTime += (double) dist[dist.length - 1] / speed;
        return totalTime <= hour;
    }
}