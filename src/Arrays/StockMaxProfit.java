package Arrays;

class StockMaxProfit {


    public static void main (String [] args){

        System.out.println(maxProfit(new int []{7,1,5,2,0,7}));
    }

    public static int maxProfit(int[] prices) {


        // //prices = [10,1,5,6,7,1]
        // lets use for loop to iterate through all elements and find max profit
        // for each item but and sell to all items on right to find all possbile profits.
        // this is very large - O(n^2)

        // lets use two points technique,
        // simply take an item and consider it as buy value.
        // now check other items to right to find currentitem<sellingitem
        // find all profits to right, find max profit.
        // time - O(n^2)
// int max_profit = 0;
//     for(int buyingPrice=0;buyingPrice<prices.length;buyingPrice++){
//         for(int SellingPrice=buyingPrice+1;SellingPrice<prices.length;SellingPrice++){
//             if(prices[buyingPrice]<prices[SellingPrice]){
//                int profit = prices[SellingPrice] - prices[buyingPrice];
//                max_profit = Math.max(max_profit,profit);
//             }



//         }
//     }
//     return max_profit;
//     }


// Lets try another way with less time
// we dont actually need two for loops.
// declare minbuy and maxprofit = 0
// then iterate through all elemts if item is less than minbuy
// that will be new minbuy
// if greater simple cal profit and check for max profit/


        int minbuy = Integer.MAX_VALUE;
        int maxProfit= 0;
        for(int item: prices){
            if (minbuy>item){
                minbuy = item;
            }
            else{
                int profit = item - minbuy;
                maxProfit = Math.max(profit,maxProfit);
            }
        }


        return maxProfit;
    }




}

