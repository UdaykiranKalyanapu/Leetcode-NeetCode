
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: Sort the array

        for (int i = 0; i < nums.length - 2; i++) { // Iterate up to nums.length - 2 because we need at least two elements after 'i'
            // Step 2: Skip duplicate 'a' values (nums[i])
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Optimization: If nums[i] is already positive, then it's impossible to get a sum of 0
            // since the array is sorted, the other numbers will also be non-negative.
            if (nums[i] > 0) {
                break;
            }

            int left = i + 1; // Step 3: Initialize two pointers
            int right = nums.length - 1;

            while (left < right) {
                int threeSum = nums[i] + nums[left] + nums[right];

                // Step 4: Adjust pointers based on the sum
                if (threeSum > 0) {
                    right--;
                } else if (threeSum < 0) {
                    left++;
                } else {
                    // Sum is 0, add the triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // Skip duplicates for 'left' and 'right' pointers
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}