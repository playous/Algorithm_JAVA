import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        
        List<Integer> list = new ArrayList<>();
        
        int[] time = new int[n];

        for (int i = 0; i < n ; i ++){
            int need = 100 - progresses[i];
            
            time[i] = need/speeds[i];
            
            if (need % speeds[i] != 0) time[i]++;
        }
        
        boolean[] visited = new boolean[n];
        
        for (int i = 0 ; i < n ; i ++){
            if (visited[i]) continue;
            
            int cur = time[i];
            visited[i] = true;
            int count = 1;
            
            for (int j = i + 1 ; j < n ; j ++){
                if (time[j] <= cur){
                    visited[j] = true;
                    count++;
                }
                else break;
            }
            
            list.add(count);
        }
        
        int[] answer = new int[list.size()]; 
        
        for (int i = 0 ; i < answer.length; i ++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}