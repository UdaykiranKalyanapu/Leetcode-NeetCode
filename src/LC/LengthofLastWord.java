package LC;

class LengthofLastWord {

    public static void main (String [] args){
        String str = "Hello World";
        System.out.println(lengthOfLastWord(str));
    }
    public static int lengthOfLastWord(String s) {
        int count  =0 ;
        //s=hello world
        int i = s.length() -1; // i = 10

        while(i>=0&& s.charAt(i) == ' '){ //inCase there is space at the end

            i--;

        }
        while(i>=0 && s.charAt(i) != ' '){
            i--;
            count++;
        }
        return count;

 // logic is directly goinf through the last position in the sentence and parsing back till we found a space by incrementing the count/
    }
}