package Tem;

public class Candy {


        public int candy(int[] ratings) {
            int n = ratings.length;
            int[] candies = new int[n];

            // Step 1: Give everyone 1 candy
            for (int i = 0; i < n; i++) {
                candies[i] = 1;
            }

            // Step 2: Left to right
            for (int i = 1; i < n; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                }
            }

            // Step 3: Right to left
            for (int i = n - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    candies[i] = Math.max(candies[i], candies[i + 1] + 1);
                }
            }

            // Step 4: Sum
            int total = 0;
            for (int c : candies) {
                total += c;
            }

            return total;
        }
    }
