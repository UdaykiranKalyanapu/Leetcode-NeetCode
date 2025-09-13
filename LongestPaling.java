public class LongestPaling {

        public String longestPalindrome(String s) {
            if (s == null || s.length() < 1) return "";

            int start = 0, end = 0;

            for (int i = 0; i < s.length(); i++) {
                // Odd-length palindrome
                int[] odd = expandAroundCenter(s, i, i);
                // Even-length palindrome
                int[] even = expandAroundCenter(s, i, i + 1);

                // Pick the longer one
                int[] longer = (odd[1] - odd[0] > even[1] - even[0]) ? odd : even;

                if (longer[1] - longer[0] > end - start) {
                    start = longer[0];
                    end = longer[1];
                }
            }

            return s.substring(start, end + 1);
        }

        private int[] expandAroundCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return new int[]{left + 1, right - 1};
        }
    }
