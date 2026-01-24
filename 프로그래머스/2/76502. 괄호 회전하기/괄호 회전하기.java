import java.util.*;

class Solution {
    static int len;
    static HashMap<Character,Integer> map = new HashMap<>();
    
    public int solution(String s) {
        int answer = 0;
        len = s.length();
        
        map.put('[', 1);
        map.put(']', 4);
        map.put('(', 2);
        map.put(')', 5);
        map.put('{', 3);
        map.put('}', 6);
        
        
        StringBuilder sb = new StringBuilder();
        sb.append(s).append(s);
        
        for (int i = 0 ; i < len; i ++){
            char[] arr = sb.substring(i, len + i).toCharArray();
            if (check(arr)) answer++;
        }
        
        return answer;
    }
    
    public static boolean check(char[] arr){
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < len ; i ++){
            int c = map.get(arr[i]);
            if(stack.isEmpty()) stack.push(c);
            else {
                if(c - stack.peek() == 3){
                    stack.pop();
                }
                else stack.push(c);
            }
        }
        
        return stack.isEmpty();
    }
}