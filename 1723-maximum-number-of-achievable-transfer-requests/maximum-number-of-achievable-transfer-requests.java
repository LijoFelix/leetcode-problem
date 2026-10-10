class Solution {
    int maxRequests = 0;

    public int maximumRequests(int n, int[][] requests) {
        backtrack(requests, 0, new int[n], 0);
        return maxRequests;
    }

    private void backtrack(int[][] requests, int index, int[] degree, int count) {
        if (index == requests.length) {
            for (int d : degree) {
                if (d != 0) return;
            }
            maxRequests = Math.max(maxRequests, count);
            return;
        }

        degree[requests[index][0]]--;
        degree[requests[index][1]]++;
        backtrack(requests, index + 1, degree, count + 1);
        degree[requests[index][0]]++;
        degree[requests[index][1]]--;

        backtrack(requests, index + 1, degree, count);
    }
}