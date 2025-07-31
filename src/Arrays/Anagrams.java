package Arrays;

import java.util.HashMap;

class Anagrams {

    public static void main(String [] args){
        String s = "racecar";
        String t = "carrace";
        System.out.println(Anagrams.isAnagram(s,t));
    }
    public static boolean isAnagram(String s, String t) {
//  /* Used Stringbuilder but there are no sorting fucntions, Hence Char [] is used to sort using Arrays.sort(); */

//  char [] sarray = s.toCharArray();
//  char [] tarray = t.toCharArray();

// Arrays.sort(sarray);
// Arrays.sort(tarray);

// if(Arrays.equals(sarray,tarray)){
//     return true;
// }
// else{
//     return false;
// }
// }



// It worked well but we are using sorting twice so thats (slogs + tlogt)
// omtimized is by using hashmap to save the occurence of characters;

        if(s.length()!=t.length()){
            return false;
        }

        HashMap<Character,Integer> countS = new HashMap<>();

        HashMap<Character,Integer> countT = new HashMap<>();


        for(int i=0;i<s.length();i++){
            countS.put(s.charAt(i),
                    countS.getOrDefault(s.charAt(i),0)+1);
            countT.put(t.charAt(i),
                    countT.getOrDefault(t.charAt(i),0)+1);


        }

        if(countS.equals(countT)){
            return true;
        }
        else{
            return false;
        }

    }}


