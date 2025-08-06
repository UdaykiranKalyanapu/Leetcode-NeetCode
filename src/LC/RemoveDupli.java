package LC;

public class RemoveDupli {

        public static int removeElement(int[] nums, int val) {
            int k = 0;
            for(int i = 0;i<nums.length;i++){

                if(nums[i]!=val){
                    nums[k] = nums[i];
                    k=k+1;
                }
            }

            return k;
        }
   public static void main (String args[]){
            int [] nums = new int[]{1,2,2,4,5};
            int val  = 2;
            System.out.println(removeElement(nums,val));

   }

    }