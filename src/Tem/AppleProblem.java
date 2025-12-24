package Tem;
import java.util.*;


public class AppleProblem {

        public int minimumBoxes(int[] apple, int[] capacity) {
            int totalApples = 0;
            for (int a : apple) {
                totalApples += a;
            }

            Arrays.sort(capacity);

            int usedBoxes = 0;
            int currentCapacity = 0;

            for (int i = capacity.length - 1; i >= 0; i--) {
                currentCapacity += capacity[i];
                usedBoxes++;
                if (currentCapacity >= totalApples) {
                    return usedBoxes;
                }
            }

            return usedBoxes;
        }
    }
