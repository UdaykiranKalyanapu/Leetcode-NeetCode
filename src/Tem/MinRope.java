package Tem;

public class MinRope {
    public int minCost(String colors, int[] neededTime) {
        int totalCost = 0;
        int maxTime = neededTime[0];

        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                // If same color, add the smaller removal cost to total
                totalCost += Math.min(maxTime, neededTime[i]);
                // Keep track of max removal time in the group (to keep it)
                maxTime = Math.max(maxTime, neededTime[i]);
            } else {
                // Reset maxTime for the next group
                maxTime = neededTime[i];
            }
        }

        return totalCost;
    }
}
