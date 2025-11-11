package Tem;

public class OnesAndZeroes {

        public int findMaxForm(String[] strs, int m, int n) {
            int[][] dp = new int[m + 1][n + 1];

            for (String s : strs) {
                int zeros = 0, ones = 0;
                for (char c : s.toCharArray()) {
                    if (c == '0') zeros++;
                    else ones++;
                }

                // iterate backwards to avoid overwriting
                for (int i = m; i >= zeros; i--) {
                    for (int j = n; j >= ones; j--) {
                        dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zeros][j - ones]);
                    }
                }
            }
            return dp[m][n];
        }
    }
