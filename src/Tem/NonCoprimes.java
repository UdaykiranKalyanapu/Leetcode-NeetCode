package Tem;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NonCoprimes {

    class Solution {
        public List<Integer> replaceNonCoprimes(int[] nums) {
            Deque<Integer> stack = new ArrayDeque<>();

            for (int num : nums) {
                stack.addLast(num);  // push

                // Keep merging while top two are non-coprime
                while (stack.size() >= 2) {
                    int b = stack.removeLast();
                    int a = stack.removeLast();
                    int g = gcd(a, b);

                    if (g > 1) {
                        // merge into LCM and push back
                        long lcm = (long) a / g * b; // avoid overflow
                        stack.addLast((int) lcm);
                    } else {
                        // push back both since they're coprime
                        stack.addLast(a);
                        stack.addLast(b);
                        break;
                    }
                }
            }

            return new ArrayList<>(stack);
        }

        private int gcd(int a, int b) {
            while (b != 0) {
                int temp = a % b;
                a = b;
                b = temp;
            }
            return a;
        }
    }
}
