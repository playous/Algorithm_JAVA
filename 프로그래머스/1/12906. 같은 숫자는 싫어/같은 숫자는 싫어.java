import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> queue = new ArrayDeque<>();
        
        for (int i : arr){
            if(queue.isEmpty() || queue.peekLast() != i){
                queue.addLast(i);
            }
        }
        
        int[] answer = new int[queue.size()];
        
        int index = 0;
        for (int i : queue){
            answer[index++] = i;
        }
        return answer;
    }
}