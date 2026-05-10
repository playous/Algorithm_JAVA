import java.util.*;

class Solution{
    public int solution(String s){
        int answer = 0;
        int len = s.length();
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < len ; i ++){
            char cur = s.charAt(i);
            if(stack.isEmpty()) stack.add(cur);
            else {
                if (stack.peek() == cur) stack.pop();
                else stack.add(cur);
            }
        }
        
        while (true){
            int curLen = stack.size();
            char[] arr = new char[curLen];
            for (int i = 0; i < curLen ; i ++){
                arr[i] = stack.pop();
            }
            
            stack = new Stack<>();
            
            for (int i = 0; i < curLen ; i ++){
                char cur = arr[i];
                if(stack.isEmpty()) stack.add(cur);
                else {
                    if (stack.peek() == cur) stack.pop();
                    else stack.add(cur);
                }
            }
            if (stack.size() == 0){
                answer = 1;
                break;
            }
                        
            if (curLen == stack.size()) break;
        }
        
        return answer;
    }
}