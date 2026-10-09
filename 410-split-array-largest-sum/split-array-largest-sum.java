class Solution {
    public int count_Splits(int[] nums, int sums) {
        int countsplits = 1;
        int countsums = 0;
        for (int i = 0; i < nums.length; i++) {
            countsums += nums[i];
            if (countsums > sums) {
                countsplits++;
                countsums = nums[i];
            }
        }

        return countsplits;

    }

    public int splitArray(int[] nums, int k) {
        //   using Binary search
        if (k > nums.length) {
            return -1;
        }

        int low = 0;
        int high = 0;
        for (int i = 0; i < nums.length; i++) {
            low = Math.max(low, nums[i]);
            high += nums[i];
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            //check the no of splits can be possible
            int splits_count = count_Splits(nums, mid);
            if (splits_count <= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}