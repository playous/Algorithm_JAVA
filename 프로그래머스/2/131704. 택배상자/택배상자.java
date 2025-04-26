import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        int mainIndex = 1; 
        
        for (int i = 0; i < order.length; i++) {
            int target = order[i]; 
            
            while (mainIndex <= order.length && mainIndex < target) {
                stack.push(mainIndex++);
            }
            
            if (mainIndex == target) {
                mainIndex++; 
                answer++;    
            } 
            else if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop(); 
                answer++;    
            } 
            else {
                break;
            }
        }
        
        return answer;
    }
}