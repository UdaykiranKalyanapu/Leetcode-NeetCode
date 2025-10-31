package Tem;

import java.util.HashMap;
import java.util.Map;

public class SneakyNumbers {
        public int[] getSneakyNumbers(int[] nums) {
            // just have to find duplicates.
            //create a list if the element already exists in  list add it to the result array [2];

            Map<Integer,Integer> hmap = new HashMap<>();
            int [] result = new int[2];
            int index = 0;
            for(int item:nums){
                hmap.put(item, hmap.getOrDefault(item,0)+1);

                if(hmap.get(item) == 2){
                    result[index] = item;
                    index++;

                }
            }

            return result;

        }
    }
