import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        LinkedList<Integer> list = new LinkedList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0 ; i < speeds.length; i++){
            stack.addLast((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }
        
        while(!stack.isEmpty()){
            int cnt = 1;
            int n = stack.removeFirst();
            while(!stack.isEmpty() && n >= stack.peekFirst()){
                cnt++;
                stack.removeFirst();
            }
            list.add(cnt);
        }
        int[] answer = new int[list.size()];
        
        int index = 0;
        
        for (int i : list){
            answer[index++] = i;
        }
        return answer;
    }
}