package Tem;

import java.util.List;

public class Triangle {

        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            // copy last row into dp array
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                dp[i] = triangle.get(n - 1).get(i);
            }

            // bottom-up calculation
            for (int row = n - 2; row >= 0; row--) {
                for (int col = 0; col <= row; col++) {
                    dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
                }
            }

            return dp[0];
        }
    }

