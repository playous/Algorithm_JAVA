import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); 
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int top = stack.pop();
                answer[top] = i - top; 
            }
            stack.push(i); 
        }
        
        while (!stack.isEmpty()) {
            int top = stack.pop();
            answer[top] = n - 1 - top; 
        }
        
        return answer;
    }
}