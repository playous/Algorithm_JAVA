import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < n ; i ++){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int id = stack.pop();
                answer[id] = i - id;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int id = stack.pop();
            answer[id] = n - id - 1; 
        }
        
        
        return answer;
    }
}