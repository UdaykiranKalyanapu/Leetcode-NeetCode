

class Solution {
    
    public static boolean isAnagram(String s, String t) {

        if(s.length()!= t.length()){
            return false;
        }
        int [] countoccurence = new int [26];
        for(int i=0;i<s.length();i++){
            countoccurence[s.charAt(i) - 'a']++;
            countoccurence[t.charAt(i) - 'a']--;

        }

        for(int i=0;i<26;i++){
            if(countoccurence[i] != 0){
                return false;
            }

        }
    return true;
}}

class Solution {
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
