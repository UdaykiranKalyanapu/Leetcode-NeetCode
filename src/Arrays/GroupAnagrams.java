package Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String item : strs) {
            char[] charArray = item.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            if (map.containsKey(sorted)) {
                // Add the current string to the existing list
                map.get(sorted).add(item);
            } else {

                List<String> newlist = new ArrayList<>();
                newlist.add(item);
                map.put(sorted, newlist);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> group : map.values()) {
            result.add(group);


        }

        return result;
    }


    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groups = ga.groupAnagrams(input);

        for (List<String> group : groups) {
            System.out.println(group);
        }
    }

}
//     }
//     public static boolean isAnagram(String string1, String string2){
//         HashMap<Character,Integer> map1 = new HashMap<>();
//         HashMap<Character,Integer> map2 = new HashMap<>();
//         if(string1.length()==string2.length()){

//         for(int i=0;i<string1.length();i++){
//             int count = map1.getOrDefault(string1.charAt(i),0);
//             map1.put(string1.charAt(i),count+1);
//              int count2 = map2.getOrDefault(string2.charAt(i),0);
//             map2.put(string2.charAt(i),count2+1);
//         }
//         if(map1.equals(map2)){
//             return true;
//         }
//         else{
//             return false;
//         }
//         }

//         else{
//             return false;
//         }
//     }
// }
