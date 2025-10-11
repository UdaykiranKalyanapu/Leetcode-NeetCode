package Tem;

import java.util.*;

public class SpellingCast {


        public long maximumTotalDamage(int[] power) {
            Map<Integer, Long> damageMap = new HashMap<>();
            for (int p : power) {
                damageMap.put(p, damageMap.getOrDefault(p, 0L) + p);
            }

            List<Integer> keys = new ArrayList<>(damageMap.keySet());
            Collections.sort(keys);

            int n = keys.size();
            long[] dp = new long[n];
            dp[0] = damageMap.get(keys.get(0));

            for (int i = 1; i < n; i++) {
                long take = damageMap.get(keys.get(i));
                int j = i - 1;
                while (j >= 0 && keys.get(i) - keys.get(j) <= 2) j--;
                if (j >= 0) take += dp[j];
                dp[i] = Math.max(dp[i - 1], take);
            }

            return dp[n - 1];
        }
    }
