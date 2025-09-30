package Tem;

public class TraingleSum {
    public int triangularSum(int[] nums) {
        int n = nums.length;

        // Repeat until one element remains
        for (int size = n; size > 1; size--) {
            for (int i = 0; i < size - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
        }

        return nums[0]; // final result
    }
}

