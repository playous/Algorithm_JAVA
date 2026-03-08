import java.util.*;

class Solution {
    
    int n;
    int answer;
    List<Integer>[][] graph;
    
    public class Node{
        int a;
        int b;
        Node(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    
    public int solution(int n, int infection, int[][] edges, int k) {
        this.answer = 1;
        this.n = n;
        boolean[] visited = new boolean[n + 1];

        graph = new List[4][n + 1];
        
        for (int i = 1 ; i <= 3; i++){
            for (int j = 1; j<= n ; j++){
                graph[i][j] = new ArrayList<>();
            }
        }
        
        for (int i = 0; i < edges.length; i ++){
            int a = edges[i][0];
            int b = edges[i][1];
            int t = edges[i][2];
  
            graph[t][a].add(b);
            graph[t][b].add(a);
            
        }
        
        visited[infection] = true;
        
        calc(k, 0, visited, 1);
        
        return answer;
    }
    
    public void calc(int k, int prev, boolean[] visited1, int count){
        if (k == 0) {
            answer = Math.max(answer, count);
            return;
        }
        for (int type = 1; type <= 3 ; type ++){
            if (type == prev) continue;
            boolean[] visited = visited1.clone();
            int cnt = count;
            
            Queue<Integer> q = new ArrayDeque<>();
            
            for (int i = 1 ; i <= n ; i ++){
                if(visited[i]) q.add(i);
            }
            
            while (!q.isEmpty()){
                int cur = q.poll();
                
                for (int next : graph[type][cur]){
                    if (!visited[next]){
                        visited[next] = true;
                        q.add(next);
                        cnt++;
                    }
                }
            }
            
            calc(k - 1, type, visited, cnt);
        }
    }
}