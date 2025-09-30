package LC;

public class FindNumBottels {
    public static int numWaterBottles(int numBottles, int numExchange) {
        // lets use simple if loop
        int sum = 0;


        while(numBottles>0){
            System.out.println(numBottles);
            sum += numBottles;
            int empty = numBottles;
            if(empty>=numExchange){
                numBottles = empty/numExchange;
            }
            else{
                numBottles = 0;
            }

        }
        return sum; }

    public static void main (String [] args){
        int numBottles = 9;
        int numExchange = 3;
        System.out.println(numWaterBottles(numBottles,numExchange));
    }
}