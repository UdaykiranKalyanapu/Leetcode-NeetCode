package LC;

import java.util.HashSet;

class FindHappynumbers {

    public static void main(String [] args){
        int x = 19;
        System.out.println(isHappy(x));
    }
    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();

        while (n != 1) {
            if (set.contains(n)) {
                return false; // cycle detected
            }
            set.add(n);
            n = findSumDigits(n); // update n with sum of squares
        }

        return true; // reached 1
    }

    private static int findSumDigits(int x) {
        int sum = 0;
        while (x > 0) {
            int digit = x % 10;
            sum += digit * digit;
            x /= 10;
        }
        return sum;
    }
}
