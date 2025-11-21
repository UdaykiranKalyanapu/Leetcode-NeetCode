package Tem;

public class CountPalindrome {
        public int countPalindromicSubsequence(String s) {
            int n = s.length();
            int[] first = new int[26];
            int[] last = new int[26];
            for (int i = 0; i < 26; i++) {
                first[i] = -1;
                last[i] = -1;
            }
            for (int i = 0; i < n; i++) {
                int c = s.charAt(i) - 'a';
                if (first[c] == -1) first[c] = i;
                last[c] = i;
            }

            int result = 0;
            for (int c = 0; c < 26; c++) {
                if (first[c] != -1 && first[c] < last[c]) {
                    boolean[] seen = new boolean[26];
                    for (int j = first[c] + 1; j < last[c]; j++) {
                        seen[s.charAt(j) - 'a'] = true;
                    }
                    for (int k = 0; k < 26; k++) {
                        if (seen[k]) result++;
                    }
                }
            }
            return result;
        }
    }
