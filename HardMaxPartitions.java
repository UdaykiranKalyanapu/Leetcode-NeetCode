public class HardMaxPartitions {

        private String s;
        private int n;
        private int k;
        private Map<Long, Integer> memo;

        public int maxPartitionsAfterOperations(String s, int k) {
            this.s = s;
            this.n = s.length();
            this.k = k;
            this.memo = new HashMap<>();
            // dfs returns how many *cuts* (i.e. times we had to start a new partition)
            // after processing from index 0 with an empty current-mask and change allowed.
            // Final partitions = cuts + 1 (if string non-empty).
            int cuts = dfs(0, true, 0);
            return (n == 0) ? 0 : cuts + 1;
        }

        // pack key: [i (higher bits)] [canChange bit at position 26] [mask in low 26 bits]
        private long packKey(int i, boolean canChange, int mask) {
            long key = ((long)i << 27) | ((canChange ? 1L : 0L) << 26) | (mask & ((1 << 26) - 1));
            return key;
        }

        private int dfs(int idx, boolean canChange, int mask) {
            if (idx == n) return 0;
            long key = packKey(idx, canChange, mask);
            if (memo.containsKey(key)) return memo.get(key);

            int curChar = s.charAt(idx) - 'a';
            int best = 0;

            // Option 1: keep current character
            int newMask = mask | (1 << curChar);
            if (Integer.bitCount(newMask) > k) {
                // start a new partition here: we count 1 cut, and mask resets to only this char
                best = 1 + dfs(idx + 1, canChange, (1 << curChar));
            } else {
                best = dfs(idx + 1, canChange, newMask);
            }

            // Option 2: use the change (if still available) to any other letter
            if (canChange) {
                for (int c = 0; c < 26; c++) {
                    if (c == curChar) continue;
                    int mask2 = mask | (1 << c);
                    int val;
                    if (Integer.bitCount(mask2) > k) {
                        // this forces a cut and mask becomes only letter c
                        val = 1 + dfs(idx + 1, false, (1 << c));
                    } else {
                        val = dfs(idx + 1, false, mask2);
                    }
                    if (val > best) best = val;
                }
            }

            memo.put(key, best);
            return best;
        }
    }

