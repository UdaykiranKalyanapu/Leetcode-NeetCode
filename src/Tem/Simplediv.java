package Tem;

public class Simplediv {


        public int minOperations(int[] nums, int k) {
            int sum = 0;
            for (int num : nums) sum += num;

            int rem = sum % k;

            // If already divisible
            if (rem == 0) return 0;

            // Otherwise need exactly 'rem' decrements
            return rem;
        }
    }
