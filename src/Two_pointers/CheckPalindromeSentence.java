package Two_pointers;

public class CheckPalindromeSentence {

   public static void main(String [] args ){
       String input = "Was it a car or a cat I saw??";
       System.out.println(isPalindrome(input));

    }
        public static boolean isPalindrome(String s) {
            // firstly remove all the spaces and convert the entire string to lower case.
            //lets use two pointers, one from start and end to check for each.

            String input = s.replaceAll("[^a-zA-Z0-9]","");
            System.out.println(input);
            input = input.toLowerCase();
            int start = 0;
            int end = input.length() - 1;
            boolean result = true;
            while(start<end){
                if(input.charAt(start) == input.charAt(end)){

                    start ++;
                    end --;
                }
                else{
                    result = false;
                    break;
                }

            }

            return result;

    }

}


