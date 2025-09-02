package LC;

import java.util.HashMap;

public class Twosums {

        public int[] twoSum(int[] nums, int target) {
            // So using two pinters is a way/
            //lets use hashmap, we calculate the diffrence and check if the element exists in the map.
            //reduces the time to O(n);


            HashMap<Integer,Integer> map = new HashMap<>();
            int [] result = new int[2];

            for(int i =0 ;i<nums.length;i++){
                map.put(nums[i],i);

            }
            for(int i=0;i<nums.length;i++){
                int difference = target - nums[i];
                if(map.containsKey(difference) && map.get(difference)!=i){
                    result[0] = i;
                    result[1] = map.get(difference);
                    return result;
                }
            }





            return result; }
    }