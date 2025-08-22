package LC;


//public class Palindrom {
//
//    public static void main (String [] args){
//        String s = "0P";
//
//
//        s = s.replaceAll("[^a-zA-Z1-9]","");
//        s=s.toLowerCase();
//
//        int i=0;
//
//        int j = s.length()-1;
//
//        System.out.println(i+" "+j);
//        boolean flag = true;
//
//        if(i==j){
//            flag = false;
//        }
//        while(i<j){
//            if(s.charAt(i)==s.charAt(j)){
//                flag = true;
//                System.out.println("i value is"+i+"the character is "+s.charAt(i));
//                System.out.println("j value is"+j+"the character is "+s.charAt(j));
//                i++;
//                j--;
//
//
//            }
//            else{
//                System.out.println("reached else");
//
//                flag = false;
//                break;
//            }
//        }
//
//System.out.println(flag);
//    }
//}


// The above solution causes O(n) time, because of the regex code.
// try the same solution with out regex.

public class Palindrom {
    public static void main (String [] args){

        String s = "absd---[][;'/.,  dsba";

        int i =0;
        int j = s.length()-1;
        boolean flag = true;

        while(i<j){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++; // skipping the non aplha numberic
                continue;

            }
            if(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
                continue;
            }

            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                System.out.println("compared are i is "+s.charAt(i)+" and j is "+s.charAt(j));
                flag = false;
                break;
            }

            i++;
            j--;}
        System.out.println(flag);
    }}