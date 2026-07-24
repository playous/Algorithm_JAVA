import java.util.*;

class Solution {
    int n;
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        this.n = n;
        
        List<Integer>[] graphIn = new List[n + 1];
        List<Integer>[] graphOut = new List[n + 1]; 
        
        for (int i = 1; i <= n ; i ++){
            graphIn[i] = new ArrayList<>();
            graphOut[i] = new ArrayList<>();
        }
        
        for (int[] arr : results){
            int a = arr[0];
            int b = arr[1];
            
            graphIn[a].add(b);
            graphOut[b].add(a);
        }
        
        for (int i = 1 ; i <= n; i ++){
            int in = bfs(i, graphIn);
            int out = bfs(i, graphOut);
            if (in + out == n - 1) answer++;
        }
        
        return answer;
    }
    
    public int bfs (int id, List<Integer>[] graph){
        int cnt = 0;
        
        boolean[] visited = new boolean[n + 1];
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(id);
        visited[id] = true;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for (int next : graph[cur]){
                if (!visited[next]){
                    visited[next] = true;
                    q.add(next);
                    cnt++;
                }
            }
        }
        
        return cnt;
        
    }
}