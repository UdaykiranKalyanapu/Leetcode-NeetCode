package LC;

class sellstocks {
    
    public static boolean isAnagram(String s, String t) {

        if(s.length()!= t.length()){
            return false;
        }
        int [] countoccurence = new int [26];
        for(int i=0;i<s.length();i++){
            countoccurence[s.charAt(i) - 'a']++;
            countoccurence[t.charAt(i) - 'a']--;

        }

        for(int i=0;i<26;i++){
            if(countoccurence[i] != 0){
                return false;
            }

        }
    return true;
}}
