package BinarySearch;

public class BinaryBasic {
public static void main (String [] args){
    int [] array = new int[]{1,2,3,4,5,6};
int target = 4;
System.out.println(search(array,target));
}


    public static int search(int[] nums, int target) {
        // IF we use a simple search using for loop its time will be O(n).
        //lesser time is possible since the array is sorted, lets find the mid check if it smaller or larger than the target.

        int left = 0;
        int right = nums.length - 1;


        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;

            } else if (nums[mid] > target) {
                right = mid - 1;

            } else if (nums[mid] < target) {
                left = mid + 1;

            }
        }

        return -1;
    }


}