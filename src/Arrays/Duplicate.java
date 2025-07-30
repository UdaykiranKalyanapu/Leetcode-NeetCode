package Arrays;

import java.util.HashSet;

class Duplicate {
    public boolean hasDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for(int item:nums){
            if(set.contains(item)){
                return true;

            }
            else{
                set.add(item);
            }

        }
        return false;
    }}