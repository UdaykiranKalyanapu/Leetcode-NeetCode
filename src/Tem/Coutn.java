package Tem;

public class Coutn {

        public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
            char[][] grid = new char[m][n];

            // Initialize the grid with empty cells
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = '.';
                }
            }

            // Place guards
            for (int[] g : guards) {
                grid[g[0]][g[1]] = 'G';
            }

            // Place walls
            for (int[] w : walls) {
                grid[w[0]][w[1]] = 'W';
            }

            // Directions: up, right, down, left
            int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };

            // Mark guarded cells
            for (int[] g : guards) {
                int x = g[0];
                int y = g[1];

                for (int[] d : directions) {
                    int dx = x + d[0];
                    int dy = y + d[1];

                    // Move in the current direction until hitting boundary, guard, or wall
                    while (dx >= 0 && dx < m && dy >= 0 && dy < n &&
                            grid[dx][dy] != 'W' && grid[dx][dy] != 'G') {
                        if (grid[dx][dy] == '.') {
                            grid[dx][dy] = 'S';  // Mark as seen
                        }
                        dx += d[0];
                        dy += d[1];
                    }
                }
            }

            // Count unguarded cells
            int unguardedCount = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '.') {
                        unguardedCount++;
                    }
                }
            }

            return unguardedCount;
        }
    }
