package LC;


class MajorityElement {

    public static void main(String [] args){
        int [] nums = new int[]{1,2,3,4,5,6,1,1,1};
        System.out.println(majorityElement(nums));
    }
    public static int majorityElement(int[] nums) {

//     int n = nums.length;
//     for(int i=0;i<n;i++){
//         int target = nums[i];
//         int count = 0;
//         for(int j=0;j<n;j++){

//             if(nums[j] == target){
//                 count++;
//                 if(count>n/2){
//                     return nums[j];


//                 }
//             }
//             else{

//             }

//         }

//     }
//    return -1; }
// }

// lets try a new variation
// we will declare a target and count and traverse through all teh elements in the array. We will decrement the count when we see any element other than target. if the count = 0, change the target to current.

        int target= 0;
        int count =1;
        target = nums[0];
        for(int i=1;i<nums.length;i++){
            if(target == nums[i]){
                count ++;
            }
            else{
                if(count == 0){
                    target = nums[i];
                    count = 1;
                }
                else{
                    count --;
                }
            }

        }
        return target;}}