package Stacks;

import java.util.Stack;

public class Parantheses {

    public static boolean isValid(String s) {
        Stack<Character> stackk = new Stack<>();

        for (char item : s.toCharArray()) {

            if (item == '(' || item == '{' || item == '[') {
                stackk.push(item);
            }
            // Handle closing brackets
            else if (item == ')' || item == '}' || item == ']') {
                if (stackk.isEmpty()) return false;

                char top = stackk.peek();
                if ((item == ')' && top == '(') ||
                        (item == '}' && top == '{') ||
                        (item == ']' && top == '[')) {
                    stackk.pop();
                } else {
                    return false;
                }
            }
        }

        // If stack is empty, all brackets matched
        return stackk.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(Parantheses.isValid("()")); // Should return true
        System.out.println(Parantheses.isValid("()[]{}")); // Should return true
        System.out.println(Parantheses.isValid("(]")); // Should return false
    }
}
/* here I have first used to create the parameters and count the inputs and outputs for each character.
However Logic doeesnt work.
Using stacks to push the open brackets and while popping using peek method to check the top.
There is another way without using stacks is by simply replacing the string containing {},(),[]
Efficient method is using stacks(time complexity is O(n).
 */