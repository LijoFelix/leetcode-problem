class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        
        int low = 1, high = length - 2;
        int peak = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = mountainArr.get(mid);
            int rightVal = mountainArr.get(mid + 1);
            if (midVal < rightVal) {
                low = mid + 1;
            } else {
                peak = mid;
                high = mid - 1;
            }
        }

        int index = binarySearchAscending(mountainArr, target, 0, peak);
        if (index != -1) {
            return index;
        }

        return binarySearchDescending(mountainArr, target, peak + 1, length - 1);
    }

    private int binarySearchAscending(MountainArray mountainArr, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = mountainArr.get(mid);
            if (val == target) {
                return mid;
            } else if (val < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private int binarySearchDescending(MountainArray mountainArr, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = mountainArr.get(mid);
            if (val == target) {
                return mid;
            } else if (val > target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}