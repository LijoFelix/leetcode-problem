class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        
        int k = primes.length;
        int[] indices = new int[k]; // Tracks the index in 'ugly' for each prime
        
        for (int i = 1; i < n; i++) {
            long nextMin = Long.MAX_VALUE;
            
            // Find the minimum next ugly number
            for (int j = 0; j < k; j++) {
                long currentProduct = (long) ugly[indices[j]] * primes[j];
                if (currentProduct < nextMin) {
                    nextMin = currentProduct;
                }
            }
            
            ugly[i] = (int) nextMin;
            
            // Advance the indices for all primes that produced this minimum
            for (int j = 0; j < k; j++) {
                if ((long) ugly[indices[j]] * primes[j] == nextMin) {
                    indices[j]++;
                }
            }
        }
        
        return ugly[n - 1];
    }
}