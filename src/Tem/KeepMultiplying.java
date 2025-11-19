package Tem;

import java.util.HashSet;

public class KeepMultiplying {


        public int findFinalValue(int[] nums, int original) {
            // Use a HashSet for O(1) lookup
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }

            // Keep multiplying until number not in set
            while (set.contains(original)) {
                original *= 2;
            }

            return original;
        }
    }

