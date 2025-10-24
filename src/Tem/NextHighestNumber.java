package Tem;

public class NextHighestNumber {

        public int nextBeautifulNumber(int n) {
            for (int num = n + 1; num <= 1224444; num++) {  // upper bound large enough
                if (isBalanced(num)) {
                    return num;
                }
            }
            return -1;
        }

        private boolean isBalanced(int num) {
            int[] count = new int[10];
            String s = Integer.toString(num);

            // count digits
            for (char c : s.toCharArray()) {
                int digit = c - '0';
                count[digit]++;
            }

            // check balance condition
            for (char c : s.toCharArray()) {
                int digit = c - '0';
                if (count[digit] != digit) {
                    return false;
                }
            }
            return true;
        }
    }

