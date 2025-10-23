package Tem;

import java.util.ArrayList;
import java.util.List;

public class CheckDigits {
        public boolean hasSameDigits(String s) {
            // Convert string to list of integers for easy processing
            List<Integer> digits = new ArrayList<>();
            for (char c : s.toCharArray()) {
                digits.add(c - '0');
            }

            // Keep performing the operation until only 2 digits remain
            while (digits.size() > 2) {
                List<Integer> next = new ArrayList<>();
                for (int i = 0; i < digits.size() - 1; i++) {
                    int newDigit = (digits.get(i) + digits.get(i + 1)) % 10;
                    next.add(newDigit);
                }
                digits = next;
            }

            // Check if final two digits are equal
            return digits.get(0).equals(digits.get(1));
        }
    }

