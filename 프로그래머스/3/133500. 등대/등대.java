import java.util.*;

class Solution {
    public int solution(int n, int[][] lighthouse) {
        int[] order = new int[n + 1];
        int[] parent = new int[n + 1];
        
        int[] dp0 = new int[n + 1];
        int[] dp1 = new int[n + 1];
        
        boolean[] visited = new boolean[n + 1];
        List<Integer>[] list = new List[n + 1];
        
        for (int i = 1 ; i <= n ; i ++){
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0 ; i < lighthouse.length; i ++){
            int a = lighthouse[i][0];
            int b = lighthouse[i][1];
            
            list[a].add(b);
            list[b].add(a);
        }
        
        int idx = 1;
        
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        visited[1] = true;
        
        while(!stack.isEmpty()){
            int cur = stack.pop();
            order[idx++] = cur;
            
            for (int next : list[cur]){
                if (visited[next]) continue;
                
                parent[next] = cur;
                visited[next] = true;
                stack.push(next);
            }   
        }
        
        // 역순 (리프 -> 루트)
        for (int i = n ; i >= 1 ; i --){
            int cur = order[i];
            
            dp0[cur] = 0;
            dp1[cur] = 1;
            
            for (int child : list[cur]){
                if (child == parent[cur]) continue;
                dp0[cur] += dp1[child];
                dp1[cur] += Math.min(dp0[child], dp1[child]);
            }
            
        }


        int answer = Math.min(dp0[1], dp1[1]);
        return answer;
    }
}