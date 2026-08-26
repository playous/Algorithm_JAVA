import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        
        int n = number.length();
        
        char[] arr = number.toCharArray();
                
        for (int i = 0; i < n ; i++){
            int cur = arr[i] - '0';
                        
            while (stack.size() > 0 && stack.peek() < cur && k > 0){
                k--;
                stack.pop();
            }
            
            stack.push(cur);
        }
        
        while (k > 0){
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        
        int size = stack.size();
        
        for (int i = 0 ; i < size; i ++){
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}