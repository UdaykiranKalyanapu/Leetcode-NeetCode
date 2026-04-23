package Tem;
import java.util.*;
public class SumofDistance {

        public long[] distance(int[] nums) {
            int n = nums.length;
            Map<Integer, List<Integer>> map = new HashMap<>();

            // group indices by value
            for (int i = 0; i < n; i++) {
                map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            }

            long[] ans = new long[n];

            for (List<Integer> list : map.values()) {
                int size = list.size();

                // prefix sum
                long[] prefix = new long[size];
                prefix[0] = list.get(0);
                for (int i = 1; i < size; i++) {
                    prefix[i] = prefix[i - 1] + list.get(i);
                }

                for (int i = 0; i < size; i++) {
                    long idx = list.get(i);

                    long sumLeft = (i > 0) ? prefix[i - 1] : 0;
                    long sumRight = prefix[size - 1] - prefix[i];

                    long countLeft = i;
                    long countRight = size - i - 1;

                    long left = idx * countLeft - sumLeft;
                    long right = sumRight - idx * countRight;

                    ans[(int) idx] = left + right;
                }
            }

            return ans;
        }
    }