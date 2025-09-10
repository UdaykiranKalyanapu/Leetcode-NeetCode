package Tem;

public class Minops {

        public int minOperations(int[] nums) {
            int n = nums.length;
            int first = nums[0];
            boolean allEqual = true;

            for (int i = 1; i < n; i++) {
                if (nums[i] != first) {
                    allEqual = false;
                    break;
                }
            }

            return allEqual ? 0 : 1;
        }
    }

