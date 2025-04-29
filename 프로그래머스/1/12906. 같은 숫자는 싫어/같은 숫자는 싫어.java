import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        LinkedList<Integer> list = new LinkedList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        
        for (int i : arr){
            if(queue.isEmpty() || queue.peekLast() != i){
                queue.addLast(i);
            }
        }
        
        for (int i : queue){
            list.add(i);
        }
        
        int[] answer = new int[list.size()];
        
        int index = 0;
        for (int i : list){
            answer[index++] = i;
        }
        return answer;
    }
}