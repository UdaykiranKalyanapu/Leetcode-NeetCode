package Tem;
import java.util.Arrays;
public class Sucessfulrain {

        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            Arrays.sort(potions);
            int n = spells.length;
            int m = potions.length;
            int[] res = new int[n];

            for (int i = 0; i < n; i++) {
                long spell = spells[i];
                // Minimum potion strength required
                long required = (success + spell - 1) / spell; // ceil(success / spell)

                int idx = binarySearch(potions, required);
                res[i] = m - idx; // all potions from idx to end are successful
            }
            return res;
        }

        private int binarySearch(int[] potions, long target) {
            int low = 0, high = potions.length;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (potions[mid] < target) low = mid + 1;
                else high = mid;
            }
            return low;
        }
    }
