import java.util.*;

class Solution {
    boolean solution(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
         for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                stack.push(ch[i]);
            } else if (ch[i] == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}