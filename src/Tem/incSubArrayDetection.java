package Tem;

import java.util.List;

public class incSubArrayDetection {

        public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
            int n = nums.size();

            for (int i = 0; i + 2 * k <= n; i++) {
                if (isIncreasing(nums, i, k) && isIncreasing(nums, i + k, k)) {
                    return true;
                }
            }
            return false;
        }

        private boolean isIncreasing(List<Integer> nums, int start, int k) {
            for (int i = start; i < start + k - 1; i++) {
                if (nums.get(i) >= nums.get(i + 1)) {
                    return false;
                }
            }
            return true;
        }
    }
