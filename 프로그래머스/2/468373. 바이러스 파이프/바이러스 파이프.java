import java.util.*;

class Solution {
    
    List<Integer>[][] list;
    int n;
    int answer = 0;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        
        this.n = n;
        list = new List[n + 1][4];
        
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= 3; j ++){
                list[i][j] = new ArrayList<>();
            }
        }
        
        for (int i = 0 ; i < edges.length ; i ++){
            int a = edges[i][0];
            int b = edges[i][1];
            int type = edges[i][2];
            
            list[a][type].add(b);
            list[b][type].add(a);

        }
        
        List<Integer> infec = new ArrayList<>();
        infec.add(infection);
        
        calc(k, -1, infec);
        
        return answer;
    }
    
    public void calc(int cnt, int before, List<Integer> infec){
        
        if (cnt == 0){
            answer = Math.max(infec.size(), answer);
            return;
        }
        
        for (int i = 1; i <= 3; i ++){
            if (i == before) continue;
            
            Queue<Integer> q = new ArrayDeque<>();
            
            boolean[] visited = new boolean[n + 1];
            List<Integer> plus = new ArrayList<>();
            
            for (int inf : infec){
                q.add(inf);
                visited[inf] = true;
            }
            
            
            while(!q.isEmpty()){
                int cur = q.poll();
                for (int next : list[cur][i]){
                    if (!visited[next]){
                        visited[next] = true;
                        plus.add(next);
                        infec.add(next);
                        q.add(next);
                    }
                }
            }
            
            calc(cnt - 1, i, infec);
            
            for (int remove : plus){
                infec.remove((Object) remove);
            }
            
        }
    }
}