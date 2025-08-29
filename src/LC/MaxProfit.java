package LC;

public class MaxProfit {


        public int maxProfit(int[] prices) {
            int minPrice = Integer.MAX_VALUE;
            int maxProfit = 0;

            for (int price : prices) {
                // Update min price if found a new lower price
                if (price < minPrice) {
                    minPrice = price;
                }
                // Calculate profit if selling today
                else if (price - minPrice > maxProfit) {
                    maxProfit = price - minPrice;
                }
            }

            return maxProfit;
        }
    }