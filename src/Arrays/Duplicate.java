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


/*
This questions can be solved by brute force by simply using two pointers to traverse through all the elements.
But it requires o(n^2)

the Optimal Solution is by using HashSet and simply check if the item presents in HashSet.
It takes only O(n) time.
 */