package Tem;

import java.util.PriorityQueue;

public class RisignWater {
        public int swimInWater(int[][] grid) {
            int n = grid.length;
            boolean[][] visited = new boolean[n][n];
            int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

            // Min-heap storing [elevation, x, y]
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            pq.offer(new int[]{grid[0][0], 0, 0});
            visited[0][0] = true;

            int maxTime = 0;

            while (!pq.isEmpty()) {
                int[] current = pq.poll();
                int height = current[0], x = current[1], y = current[2];
                maxTime = Math.max(maxTime, height);

                // If we've reached the destination
                if (x == n - 1 && y == n - 1) {
                    return maxTime;
                }

                // Explore all 4 directions
                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        pq.offer(new int[]{grid[nx][ny], nx, ny});
                    }
                }
            }

            return maxTime;
        }
    }
