package Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSums {
   public static void main (String [] args){
       System.out.println(Arrays.toString(TwoSums.twoSum(new int[]{3, 2, 1, 5}, 7)));
   }
        public static int[] twoSum(int[] nums, int target) {

  /*
  lets try with using two pointers,

  here we are using two loops so time is O(n^2);


  */


//   int [] arr = new int [2];
//   for(int i =0;i<nums.length;i++){
//     for(int j =i;j<nums.length;j++){
//         if(nums[i]+nums[j] == target && i!=j){
//             arr[0] = i;
//             arr[1] = j;
//         }
//     }
//   }

//   return arr;

//     }

    /*

lets firstly use hash maps to save the array values with indices.
then we will traverse through each item and check if difference exists in the rest
    */

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            int[] result = new int[2];
            for (int i = 0; i < nums.length; i++) {
                int diff = target - nums[i];

                if (map.containsKey(diff) && map.get(diff) != i) {
                    result[0] = i;
                    result[1] = map.get(diff);
                    break;
                }
            }

            return result;
        }
    }
