package Tem;

public class SmallestBits {

        public int smallestNumber(int n) {
            int x = 1;
            while ((x - 1) < n) {
                x <<= 1; // multiply by 2
            }
            return x - 1; // number with all bits set (like 1, 3, 7, 15, 31...)
        }
    }
