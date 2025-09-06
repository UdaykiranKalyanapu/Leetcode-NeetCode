package LC;

public class Palindnumber {




        public static void main (String [] args){
            String ransomNote = "aa";
            String a = "aaaasdasdasd";
            System.out.println(canConstruct(ransomNote,a));
        }
        public static boolean canConstruct(String ransomNote, String magazine) {
            // to check if the substring exists/
            //using an array to store the count

            int [] count = new int [26];
            for(int i=0;i<magazine.length();i++){
                count[magazine.charAt(i)- 'a']++;

            }
            for(char item:ransomNote.toCharArray()){
                if(count[item - 'a']==0){
                    return false;
                }
                count[item -'a']--;
            }
            return true; }
    }

