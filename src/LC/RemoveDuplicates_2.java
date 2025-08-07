package LC;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicates_2 {



    public static void main (String [] args){

        int [] nums = new int[]{1,0,0,0,0,0,0,0,0};
        System.out.println(removeDuplicates(nums));
    }
        public static int removeDuplicates(int[] nums) {
            if (nums.length == 0) return 0;

            int k = 1; // Start from 1 since the first element is always unique

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[k - 1]) {
                    nums[k] = nums[i]; // Move unique element forward
                    k++;
                }
            }

            return k;
        }
    }
