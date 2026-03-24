package Tem;

public class ConstructProductMatrix {

        public int[][] constructProductMatrix(int[][] grid) {
            int n = grid.length, m = grid[0].length, MOD = 12345;
            int total = n * m;

            int[] left = new int[total];
            left[0] = 1;
            for (int pos = 1; pos < total; pos++) {
                int prev_pos = pos - 1;
                int prev_i = prev_pos / m;
                int prev_j = prev_pos % m;
                int prev_val = grid[prev_i][prev_j];
                left[pos] = (int)((long)left[prev_pos] * prev_val % MOD);
            }

            int[][] dp = new int[n][m];
            int right_prod = 1;
            for (int pos = total - 1; pos >= 0; pos--) {
                int i = pos / m;
                int j = pos % m;

                dp[i][j] = (int)((long)left[pos] * right_prod % MOD);

                right_prod = (int)((long)right_prod * grid[i][j] % MOD);
            }

            return dp;
        }
    }