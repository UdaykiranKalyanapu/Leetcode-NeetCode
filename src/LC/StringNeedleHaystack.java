package LC;

public class StringNeedleHaystack {
    public static void main (String [] args){
        String needle = "ll";
        String Haystack = "Hello";
        System.out.println(strStr(Haystack,needle));
    }
        public static int  strStr(String haystack, String needle) {
            // convert the Strings to Char arrays and check for the string using For loops that is O(n^2)
// check for forst elemt of needle in the haystack, once fouond check if the substring (length of needle ) is equal to needle.
// if not return -1.
//

            int haystackLength = haystack.length();
            int needleLength = needle.length();

            for(int i=0;i<=haystackLength - needleLength;i++){
                if(haystack.substring(i,i+needleLength).equals(needle)){
                    return i;


                }

            }

            return -1;
        }}