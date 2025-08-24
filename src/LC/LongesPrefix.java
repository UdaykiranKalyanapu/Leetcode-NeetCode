package LC;

import java.util.Arrays;
public class LongesPrefix {


    public static void main(String [] args) {
        String[] str = new String[]{"hello", "hell", "he"};
        Arrays.sort(str);
        System.out.println(Arrays.toString(str));
        if (str == null || str.length == 0) {
            System.out.println("no prefix");
        }

        String first = str[0]; //he
        String last = str[str.length - 1]; //hello
        int pointer = 0;
        while (pointer < first.length() && pointer < last.length() && first.charAt(pointer) == last.charAt(pointer)) {
            pointer++;
        }
        System.out.println(first.substring(0, pointer));
    }}