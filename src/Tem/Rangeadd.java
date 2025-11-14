package Tem;

public class Rangeadd {

        public int[][] rangeAddQueries(int n, int[][] queries) {
            int[][] diff = new int[n + 1][n + 1];

            // Mark the difference array
            for (int[] q : queries) {
                int r1 = q[0], c1 = q[1];
                int r2 = q[2], c2 = q[3];

                diff[r1][c1] += 1;
                if (c2 + 1 < n) diff[r1][c2 + 1] -= 1;
                if (r2 + 1 < n) diff[r2 + 1][c1] -= 1;
                if (r2 + 1 < n && c2 + 1 < n) diff[r2 + 1][c2 + 1] += 1;
            }

            // Prefix sum row-wise
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    diff[i][j] += diff[i][j - 1];
                }
            }

            // Prefix sum column-wise
            for (int j = 0; j < n; j++) {
                for (int i = 1; i < n; i++) {
                    diff[i][j] += diff[i - 1][j];
                }
            }

            // Build the result matrix
            int[][] result = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    result[i][j] = diff[i][j];
                }
            }

            return result;
        }
    }
