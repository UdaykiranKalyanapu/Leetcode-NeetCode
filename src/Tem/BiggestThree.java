package Tem;
import java.util.*;
public class BiggestThree {



        public List<Integer> getBiggestThree(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;

            TreeSet<Integer> uniqueSum = new TreeSet<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    uniqueSum.add(grid[i][j]);

                    for (int len = 1; i + 2 * len < n && j - len >= 0 && j + len < m; len++) {
                        int currentSum = 0;

                        for (int ind = 0; ind < len; ind++)
                            currentSum += grid[i + ind][j + ind];

                        for (int ind = 0; ind < len; ind++)
                            currentSum += grid[i + len + ind][j + len - ind];

                        for (int ind = 0; ind < len; ind++)
                            currentSum += grid[i + 2 * len - ind][j - ind];

                        for (int ind = 0; ind < len; ind++)
                            currentSum += grid[i + len - ind][j - len + ind];

                        uniqueSum.add(currentSum);
                    }
                }
            }

            List<Integer> ans = new ArrayList<>();
            Iterator<Integer> it = uniqueSum.descendingIterator();

            while (it.hasNext() && ans.size() < 3) {
                ans.add(it.next());
            }

            return ans;
        }
    }