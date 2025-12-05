package Tem;

public class CountPartitions {

        public int countPartitions(int[] nums) {
            int n = nums.length;
            int total = 0;
            for (int x : nums) {
                total += x;
            }
            if ((total & 1) == 1) {
                return 0;           // total sum is odd → no valid partitions
            }
            return n - 1;           // total sum is even → all n-1 partitions are valid
        }
    }

