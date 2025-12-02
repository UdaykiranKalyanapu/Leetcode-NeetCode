package Tem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTrapezoids {

        static final long MOD = 1_000_000_007;

        public int countTrapezoids(int[][] points) {
            // Group points by y-coordinate
            Map<Integer, Long> map = new HashMap<>();
            for (int[] p : points) {
                int y = p[1];
                map.put(y, map.getOrDefault(y, 0L) + 1);
            }

            // Compute C(k,2) for each y-level (horizontal segments)
            List<Long> pairs = new ArrayList<>();
            for (long k : map.values()) {
                if (k >= 2) {
                    long c2 = (k * (k - 1) / 2) % MOD;  // number of horizontal pairs
                    pairs.add(c2);
                }
            }

            // If fewer than 2 layers have horizontal pairs → no trapezoids
            if (pairs.size() < 2) return 0;

            // Count sum over all pairs: sum_i<j (pairs[i] * pairs[j])
            long sum = 0;
            long prefix = 0;
            for (long val : pairs) {
                sum = (sum + (prefix * val) % MOD) % MOD;
                prefix = (prefix + val) % MOD;
            }

            return (int) sum;
        }
    }

