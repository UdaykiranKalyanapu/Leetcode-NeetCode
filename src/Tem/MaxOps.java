package Tem;

public class MaxOps {

        public int maxOperations(String s) {
            int zeroBlocks = 0;
            int operations = 0;
            int n = s.length();

            // Count zero blocks
            for (int i = 0; i < n; ) {
                if (s.charAt(i) == '0') {
                    zeroBlocks++;
                    while (i < n && s.charAt(i) == '0') i++;  // skip block
                } else {
                    i++;
                }
            }

            int currentBlocks = 0;

            // Now count contributions
            for (int i = 0; i < n; ) {
                if (s.charAt(i) == '0') {
                    currentBlocks++;
                    while (i < n && s.charAt(i) == '0') i++; // skip block
                } else {
                    operations += currentBlocks;
                    i++;
                }
            }

            return operations;
        }
    }
