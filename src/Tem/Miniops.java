package Tem;

public class Miniops {
        public boolean checkOnesSegment(String s) {
            boolean seenZero = false;

            for(char c : s.toCharArray()) {
                if(c == '0') {
                    seenZero = true;
                } else if(seenZero) {
                    return false;
                }
            }

            return true;
        }
    }
