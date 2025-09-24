package Tem;

import java.util.HashMap;

public class Fractions {

        public String fractionToDecimal(int numerator, int denominator) {
            if (numerator == 0) return "0";

            StringBuilder result = new StringBuilder();

            // Handle negative numbers
            if ((numerator < 0) ^ (denominator < 0)) {
                result.append("-");
            }

            // Use long to avoid overflow
            long num = Math.abs((long) numerator);
            long den = Math.abs((long) denominator);

            // Append integer part
            result.append(num / den);
            num %= den;
            if (num == 0) return result.toString();

            // Append decimal point
            result.append(".");
            HashMap<Long, Integer> map = new HashMap<>();

            while (num != 0) {
                if (map.containsKey(num)) {
                    int index = map.get(num);
                    result.insert(index, "(");
                    result.append(")");
                    break;
                }
                map.put(num, result.length());
                num *= 10;
                result.append(num / den);
                num %= den;
            }

            return result.toString();
        }
    }
