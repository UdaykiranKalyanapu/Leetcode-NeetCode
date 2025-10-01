package LC;

import static LC.FindNumBottels.numWaterBottles;

public class FindNumBottels {

        public int static numWaterBottles(int numBottles, int numExchange) {
            int sum = 0;
            int empty = 0;

            while (numBottles > 0) {
                // Drink all available bottles
                sum += numBottles;
                empty += numBottles;

                // Exchange empty bottles
                numBottles = empty / numExchange;
                empty = empty % numExchange;
            }

            return sum;
        }



    public static void main (String [] args){
        int numBottles = 9;
        int numExchange = 3;
        System.out.println(FindNumBottels.numWaterBottles(numBottles,numExchange));
    }
}