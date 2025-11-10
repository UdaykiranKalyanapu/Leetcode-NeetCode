package Tem;

import java.util.ArrayList;
import java.util.List;

public class MinimumOpearation {
    public int minOperations(int[] nums) {
        List<Integer> s = new ArrayList<>();
        int res = 0;

        for (int a : nums) {
            // Remove all previous values greater than current
            while (!s.isEmpty() && s.get(s.size() - 1) > a) {
                s.remove(s.size() - 1);
            }

            if (a == 0) continue; // ignore zeros

            // If current is new (higher) than last seen, it’s a new operation
            if (s.isEmpty() || s.get(s.size() - 1) < a) {
                res++;
                s.add(a);
            }
        }

        return res;
    }
}
