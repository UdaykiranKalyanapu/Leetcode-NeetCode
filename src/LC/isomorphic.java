package LC;

import java.util.HashMap;

public class isomorphic {
    public static void main (String [] args){

    }
        public boolean isIsomorphic(String s, String t) {
            //lets try with using hashmaps, Firstl we will save the key as char from s and values as char from t.
            // then if we get a key that already exists and values are not same, return false;
            //if reached end of string, return true.


            HashMap<Character, Character> map = new HashMap<>();
            HashMap <Character, Character> mapTS = new HashMap<>();
            if(s.length()!=t.length()){
                return false;
            }
            for(int i=0;i<s.length();i++){
                if(map.containsKey(s.charAt(i))){
                    if(map.get(s.charAt(i))!= t.charAt(i)){
                        return false;
                    }

                }
                else{
                    map.put(s.charAt(i),t.charAt(i));
                }
                if (mapTS.containsKey(t.charAt(i))) {
                    if (mapTS.get(t.charAt(i)) != s.charAt(i)) {
                        return false;
                    }
                } else {
                    mapTS.put(t.charAt(i), s.charAt(i));
                }
            }

            return true;  }
    }
