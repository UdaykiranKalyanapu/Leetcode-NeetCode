package Arrays;
//
//import java.util.Arrays;
//import java.util.HashMap;
//
//public class MostKfreq {
//    public static void main (String [] args){
//        int [] nums = {1,1,2,3,4,5,5,5,6};
//        int k = 2;
//        findKfreq(k,nums);
//
//    }
//    public static  void findKfreq( int k,  int [] nums){
//        HashMap <Integer,Integer> map = new HashMap<>();
//        for(int item: nums){
//            map.put(item,map.getOrDefault(item,0)+1);
//        }
//
//        int [] arr = new int[map.size()];
//        int index= 0;
//        for(int item:map.values()){
//            arr[index] = item;
//            index ++;
//        }
//        Arrays.sort(arr);
//        int [] desc = new int[arr.length];
//        for(int i=0;i<desc.length;i++){
//            desc[i] = arr[arr.length-1-i];
//        }
//        System.out.println(Arrays.toString(desc));
//
//        int max_freq = -1;
//int most_freq = 0;
//        for(int item: map.keySet()){
//            if(max_freq < map.get(item)){
//                max_freq = map.get(item);
//                most_freq = item;
//            }
//
//        }
//
//
//
//     }
//}

import java.util.*;

public class MostKfreq {

    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequency of each element
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets. Index = frequency, value = list of numbers
        List<Integer>[] buckets = new List[nums.length + 1]; // max frequency = nums.length
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        // Step 3: Collect top k frequent elements from buckets (from end to start)
        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            if (buckets[i] != null) {
                result.addAll(buckets[i]);
            }
        }

        // Convert result list to int array
        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = result.get(i);
        }

        return topK;
    }

    // Test
    public static void main(String[] args) {
        MostKfreq solution = new MostKfreq();
        int[] result = solution.topKFrequent(new int[]{1, 2, 2, 3, 3, 3}, 2);
        System.out.println(Arrays.toString(result)); // Output: [3, 2] or [2, 3]
    }
}

