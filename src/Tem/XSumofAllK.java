package Tem;

import java.util.*;

public class XSumofAllK {
        static class Pair {
            int freq, val;
            Pair(int f, int v) { freq = f; val = v; }
            @Override
            public boolean equals(Object o) {
                if (!(o instanceof Pair)) return false;
                Pair p = (Pair) o;
                return freq == p.freq && val == p.val;
            }
            @Override
            public int hashCode() {
                return Objects.hash(freq, val);
            }
        }

        static final Comparator<Pair> cmp = (a, b) -> {
            if (a.freq != b.freq) return b.freq - a.freq;
            return b.val - a.val;
        };

        public long[] findXSum(int[] nums, int k, int x) {
            Map<Integer, Integer> freq = new HashMap<>();
            TreeSet<Pair> top = new TreeSet<>(cmp);
            TreeSet<Pair> rest = new TreeSet<>(cmp);
            long[] topSum = new long[1];   // ✅ lambda-safe mutable var
            long[] ans = new long[nums.length - k + 1];

            Runnable balance = () -> {
                while (top.size() < x && !rest.isEmpty()) {
                    Pair p = rest.pollFirst();
                    top.add(p);
                    topSum[0] += (long) p.freq * p.val;
                }
                while (top.size() > x) {
                    Pair p = top.pollLast();
                    topSum[0] -= (long) p.freq * p.val;
                    rest.add(p);
                }
                while (!rest.isEmpty() && !top.isEmpty() && cmp.compare(rest.first(), top.last()) < 0) {
                    Pair big = rest.pollFirst();
                    Pair small = top.pollLast();
                    topSum[0] += (long) big.freq * big.val - (long) small.freq * small.val;
                    top.add(big);
                    rest.add(small);
                }
            };

            java.util.function.IntConsumer add = num -> {
                int oldFreq = freq.getOrDefault(num, 0);
                Pair oldPair = new Pair(oldFreq, num);

                if (oldFreq > 0) {
                    if (top.remove(oldPair)) {
                        topSum[0] -= (long) oldFreq * num;
                    } else rest.remove(oldPair);
                }

                int newFreq = oldFreq + 1;
                freq.put(num, newFreq);
                rest.add(new Pair(newFreq, num));
                balance.run();
            };

            java.util.function.IntConsumer remove = num -> {
                int oldFreq = freq.get(num);
                Pair oldPair = new Pair(oldFreq, num);

                if (top.remove(oldPair)) {
                    topSum[0] -= (long) oldFreq * num;
                } else {
                    rest.remove(oldPair);
                }

                int newFreq = oldFreq - 1;
                if (newFreq > 0) {
                    freq.put(num, newFreq);
                    rest.add(new Pair(newFreq, num));
                } else freq.remove(num);

                balance.run();
            };

            for (int i = 0; i < k; i++) add.accept(nums[i]);
            ans[0] = topSum[0];

            for (int i = k; i < nums.length; i++) {
                remove.accept(nums[i - k]);
                add.accept(nums[i]);
                ans[i - k + 1] = topSum[0];
            }

            return ans;
        }
    }
