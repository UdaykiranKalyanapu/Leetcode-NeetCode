package LC;

import java.util.HashMap;

public class RomantoIntegers {

    public static void main( String [] args) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
String s = "MCMXCVIII";
        int n = s.length();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int current = map.get(s.charAt(i));

           if(i<n-1 && current < map.get(s.charAt(i+1))){
               sum = sum-current;
           }
           else{
               sum = sum + current;
           }
        } // we can also use a logic called (smaller number is smaller than 1/4th of larger number).
    System.out.println(sum);
    }
}