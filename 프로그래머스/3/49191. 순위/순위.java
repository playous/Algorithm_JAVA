import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int len = results.length;
        
        List<Integer>[] win_list = new List[n+1];
        List<Integer>[] def_list = new List[n+1];
        
        for (int i = 1; i <= n ; i ++){
            win_list[i] = new ArrayList<>();
            def_list[i] = new ArrayList<>();
        }
        
        for (int i = 0 ; i < len ; i++){
            int win = results[i][0];
            int def = results[i][1];
            win_list[win].add(def);
            def_list[def].add(win);
        }
        
        for (int i = 1; i <= n ; i++){
            boolean[] visited = new boolean[n+1];
            visited[i] = true;
            
            Queue<Integer> win_q = new ArrayDeque<>();
            Queue<Integer> def_q = new ArrayDeque<>();
            win_q.add(i);
            def_q.add(i);
                        
            int count = 1;
            
            while (!win_q.isEmpty()){
                int cur = win_q.poll();
                for (int next : win_list[cur]){
                    if (!visited[next]){
                        visited[next] = true;
                        count++;
                        win_q.add(next);
                    }
                }
            }
              
            while (!def_q.isEmpty()){
                int cur = def_q.poll();
                for (int next : def_list[cur]){
                    if (!visited[next]){
                        visited[next] = true;
                        count++;
                        def_q.add(next);
                    }
                }
            }
            
            if (count == n) answer ++;
            
        }
        return answer;
    }
}