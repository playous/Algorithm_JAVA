import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0 ; i < n ; i ++){
            int remain = 100 - progresses[i];
            
            int time = remain / speeds[i];
            
            if (remain % speeds[i] != 0) time++;
            q.add(time);
        }
        
        while (!q.isEmpty()){
            int num = 1;
            int cur = q.poll();
            while (!q.isEmpty() && q.peek() <= cur){
                q.poll();
                num++;
            }
            list.add(num);
        }
        
        int[] answer = new int[list.size()];
        
        for (int i = 0 ; i < answer.length; i ++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}