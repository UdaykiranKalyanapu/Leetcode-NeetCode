package Tem;

public class maxoint {

        final long MOD = 1_000_000_007L;

        private long modPow(long a, long e) {
            long r = 1;
            while (e > 0) {
                if ((e & 1) == 1) r = (r * a) % MOD;
                a = (a * a) % MOD;
                e >>= 1;
            }
            return r;
        }

        public int magicalSum(int m, int k, int[] nums) {
            int n = nums.length;
            // max bit to process: n - 1 (highest index) + enough extra bits for carries
            int maxBit = n + 6; // 6 is safe for m <= 30

            // Precompute factorials and inverse factorials up to m
            long[] fact = new long[m+1];
            long[] invFact = new long[m+1];
            fact[0] = 1;
            for (int i = 1; i <= m; ++i) fact[i] = fact[i-1] * i % MOD;
            invFact[m] = modPow(fact[m], MOD - 2);
            for (int i = m - 1; i >= 0; --i) invFact[i] = invFact[i+1] * (i+1) % MOD;

            // Precompute powers: powVal[j][c] = nums[j]^c % MOD for c=0..m
            long[][] powVal = new long[n][m+1];
            for (int j = 0; j < n; ++j) {
                powVal[j][0] = 1;
                long base = nums[j] % MOD;
                for (int c = 1; c <= m; ++c) powVal[j][c] = powVal[j][c-1] * base % MOD;
            }

            // dp[used][carry][ones] = sum of products (∏ nums[j]^c_j / ∏ c_j!) for processed bits so far.
            // Use rolling arrays over bit index.
            // dims: used: 0..m, carry: 0..m, ones: 0..m
            int U = m + 1;
            int C = m + 1;
            int O = m + 1;
            long[][][] dp = new long[U][C][O];
            dp[0][0][0] = 1; // no picks, zero carry, zero ones

            for (int bit = 0; bit < maxBit; ++bit) {
                long[][][] ndp = new long[U][C][O];

                // For indices < n we can pick c_j in 0..(m-used); for bit >= n, c_j must be 0.
                boolean hasIndex = (bit < n);

                for (int used = 0; used <= m; ++used) {
                    for (int carry = 0; carry <= m; ++carry) {
                        for (int ones = 0; ones <= m; ++ones) {
                            long cur = dp[used][carry][ones];
                            if (cur == 0) continue;

                            if (!hasIndex) {
                                // c = 0 only
                                int sum = carry; // carry + c
                                int bitVal = sum & 1;
                                int ncarry = sum >> 1;
                                int nones = ones + bitVal;
                                if (nones <= m && ncarry <= m) {
                                    ndp[used][ncarry][nones] = (ndp[used][ncarry][nones] + cur) % MOD;
                                }
                            } else {
                                int j = bit; // index j = bit
                                int maxC = m - used;
                                for (int c = 0; c <= maxC; ++c) {
                                    int sum = carry + c;
                                    int bitVal = sum & 1;
                                    int ncarry = sum >> 1;
                                    int nUsed = used + c;
                                    int nOnes = ones + bitVal;
                                    if (ncarry > m || nOnes > m) continue;

                                    // multiply cur by nums[j]^c * invFact[c]
                                    long add = cur * powVal[j][c] % MOD;
                                    add = add * invFact[c] % MOD;

                                    ndp[nUsed][ncarry][nOnes] = (ndp[nUsed][ncarry][nOnes] + add) % MOD;
                                }
                            }
                        }
                    }
                }
                dp = ndp;
            }

            // After processing bits, valid results are states with used == m, carry == 0, ones == k
            long ansPart = dp[m][0][k]; // this is sum of (∏ nums[j]^c_j / ∏ c_j!) over valid count-distributions

            // Multiply by m! to convert to ordered sequences
            long ans = ansPart * fact[m] % MOD;
            return (int) ans;
        }
    }
