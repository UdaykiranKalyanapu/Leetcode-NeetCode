package Tem;

public class Sudoko {

        public int numMagicSquaresInside(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int ans=0;
            for(int i=0;i<n-2;i++){
                for(int j=0;j<m-2;j++){
                    if(isMagicSquare(grid, i, j)) ans++;
                }
            }
            return ans;
        }
        public boolean isMagicSquare(int[][] grid, int x, int y){
            boolean[] visited = new boolean[10];
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    int num = grid[i+x][j+y];
                    if(num<1 || num>9 || visited[num]) return false;
                    visited[num] = true;
                }
            }
            int targetSum = grid[x][y] + grid[x][y+1] + grid[x][y+2];
            if(grid[x+1][y] + grid[x+1][y+1] + grid[x+1][y+2] != targetSum) return false;
            if(grid[x+2][y] + grid[x+2][y+1] + grid[x+2][y+2] != targetSum) return false;
            for(int c=0;c<3;c++){
                if(grid[x][y+c] + grid[x+1][y+c] + grid[x+2][y+c] != targetSum) return false;
            }
            if(grid[x][y] + grid[x+1][y+1] + grid[x+2][y+2] != targetSum) return false;
            if(grid[x][y+2] + grid[x+1][y+1] + grid[x+2][y] != targetSum) return false;
            return true;
        }
    }