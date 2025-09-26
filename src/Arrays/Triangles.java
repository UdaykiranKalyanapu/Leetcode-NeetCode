package Arrays;
import java.util.Arrays;
public class Triangles {

        public int triangleNumber(int[] nums) {
            // Sum of any two sides should be greater than third side,

            //lets sue two pointers and sum them to check if it is greater than how many elements?
            //its time complexity is huge.


            Arrays.sort(nums);


            int count =0;
            for(int max=nums.length-1;max>=2;max--){
                int i=0;
                int j = max-1;

                while(i<j){
                    if(nums[i]+nums[j] > nums[max]){
                        count = count + (j-i);
                        j--;
                    }

                    else{
                        i++;
                    }
                }
            }
            return count;
        }
    }
