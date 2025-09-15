package Tem;

public class ContainsInString {



        public int canBeTypedWords(String text, String brokenLetters) {
            int count = 0;
            String[] words = text.split(" ");

            for (String word : words) {
                boolean canType = true; // reset for each word
                for (char c : word.toCharArray()) {
                    if (brokenLetters.indexOf(c) != -1) {
                        canType = false;
                        break; // stop checking this word
                    }
                }
                if (canType) {
                    count++;
                }
            }

            return count;
        }
    }
