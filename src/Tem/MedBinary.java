package Tem;

import java.util.HashSet;
import java.util.Set;

public class MedBinary {

        public boolean hasAllCodes(String s, int k) {
            //int total = (int)Math.pow(2,k);
            int total = 1<<k;
            Set<String> set=new HashSet();


            for(int i=k; i<=s.length(); i++){
                String s1=s.substring(i-k,i);

                if(!set.contains(s1)){
                    set.add(s1);
                }
            }

            if(set.size()==total)  return true;


            return false;
        }
    }