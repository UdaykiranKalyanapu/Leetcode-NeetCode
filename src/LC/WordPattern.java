package LC;
import java.util.HashMap;
public class WordPattern {

    public static void main (String [] args){
        String pattern = "abba";
        String s = "cat dog dog cat";
            System.out.println(wordPattern(pattern,s));
            }

        public static boolean wordPattern(String pattern, String s) {
            //we can use Map to save the key and value, if the key is new, add to map.
            // the key exists, check if value is same
            String [] stringarr = new String[s.length()];
            stringarr = s.split(" ");
            HashMap<Character,String> chartowordmap = new HashMap<>();
            HashMap<String,Character> wordtochaarmap = new HashMap<>();
            if(pattern.length() != stringarr.length){
                return false;
            }
            //creating string[] for easy access

            for(int i=0;i<stringarr.length;i++ ){

                char ch = pattern.charAt(i);
                String st = stringarr[i];
                if(chartowordmap.containsKey(ch)){
                    if(!chartowordmap.get(ch).equals(st)){
                        return false;
                    }


                }
                else{
                    chartowordmap.put(ch,st);
                }


                if(wordtochaarmap.containsKey(st)){
                    if(!wordtochaarmap.get(st).equals(ch)){
                        return false;
                    }

                }
                else{
                    wordtochaarmap.put(st,ch);
                }


            }


            return true;

        }
    }