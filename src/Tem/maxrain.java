package Tem;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class maxrain {
        public List<String> removeAnagrams(String[] words) {
            List<String> result = new ArrayList<>();

            for (String word : words) {
                // If result is empty or current word is NOT an anagram of last word
                if (result.isEmpty() || !isAnagram(result.get(result.size() - 1), word)) {
                    result.add(word);
                }
            }

            return result;
        }

        // Helper method to check if two words are anagrams
        private boolean isAnagram(String a, String b) {
            if (a.length() != b.length()) return false;

            char[] arr1 = a.toCharArray();
            char[] arr2 = b.toCharArray();

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            return Arrays.equals(arr1, arr2);
        }
    }
