package LC;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TwosumsTest {

    @Test
    void testExample1() {
        Twosums sol = new Twosums();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = sol.twoSum(nums, target);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    void testExample2() {
        Twosums sol = new Twosums();
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = sol.twoSum(nums, target);
        assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    void testExample3() {
        Twosums sol = new Twosums();
        int[] nums = {3, 3};
        int target = 6;
        int[] result = sol.twoSum(nums, target);
        assertArrayEquals(new int[]{0, 1}, result);
    }


        public static void main(String[] args) {
            Twosums sol = new Twosums();
            int[] result = sol.twoSum(new int[]{2, 7, 11, 15}, 9);
            System.out.println(result[0] + ", " + result[1]);
        }

}
