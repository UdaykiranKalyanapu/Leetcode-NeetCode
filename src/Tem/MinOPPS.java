package Tem;

public class MinOPPS {

        public int minOperations(int[] nums) {
            int n = nums.length;

            int ones = 0;
            for (int x : nums) {
                if (x == 1) ones++;
            }

            // Case A: If we already have ones
            if (ones > 0) {
                return n - ones;  // each non-1 needs 1 operation
            }

            // Case B: No 1's → find smallest subarray with gcd = 1
            int best = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                int g = nums[i];
                for (int j = i + 1; j < n; j++) {
                    g = gcd(g, nums[j]);
                    if (g == 1) {
                        best = Math.min(best, j - i + 1);
                        break;  // no need to extend this i, already found min
                    }
                }
            }

            if (best == Integer.MAX_VALUE) return -1; // no gcd = 1

            return (best - 1) + (n - 1);
        }

        private int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }

