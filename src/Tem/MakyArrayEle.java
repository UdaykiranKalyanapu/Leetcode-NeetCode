package Tem;

public class MakyArrayEle {


        public int countValidSelections(int[] nums) {
            int n = nums.length;
            int result = 0;

            // Try each zero position as a starting point
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    // Try both left (-1) and right (+1) directions
                    if (simulate(nums.clone(), i, -1)) result++;
                    if (simulate(nums.clone(), i, 1)) result++;
                }
            }
            return result;
        }

        private boolean simulate(int[] nums, int start, int dir) {
            int n = nums.length;
            int curr = start;

            while (curr >= 0 && curr < n) {
                if (nums[curr] == 0) {
                    curr += dir; // move in the same direction
                } else {
                    nums[curr]--; // reduce value
                    dir = -dir;   // reverse direction
                    curr += dir;  // move after reversing
                }
            }

            // Check if all elements are zero
            for (int val : nums)
                if (val != 0)
                    return false;
            return true;
        }
    }
