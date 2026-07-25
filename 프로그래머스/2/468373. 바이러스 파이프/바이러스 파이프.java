import java.util.*;

class Solution {
    class Node {
        int id;
        int type;
        Node (int id, int type){
            this.id = id;
            this.type = type;
        }
    }
    
    List<Node>[] graph;
    int answer = 0;
    int n;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        this.n = n;
        
        graph = new List[n + 1];
        
        for (int i = 1 ; i <= n ; i++){
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edges.length; i ++){
            int a = edges[i][0];
            int b = edges[i][1];
            int type = edges[i][2];
            graph[a].add(new Node(b, type));
            graph[b].add(new Node(a, type));
        }
        
        HashSet<Integer> set = new HashSet<>();
        set.add(infection);
        
        for (int i = 1; i <= 3; i ++){
            dfs(i, k, set);    
        }
        
        return answer;
    }
    
    public void dfs(int type, int count, HashSet<Integer> set){
        if (count == 0){
            answer = Math.max(set.size(), answer);
            return;    
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        HashSet<Integer> nextSet = new HashSet<>(set);
            
        boolean[] visited = new boolean[n + 1];
        for (int num : set){
            q.add(num);
            visited[num] = true;
        }
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for (Node next : graph[cur]){
                if (!visited[next.id] && next.type == type){
                    nextSet.add(next.id);
                    visited[next.id] = true;
                    q.add(next.id);
                }
            }
        }
        
        for (int i = 1; i <= 3 ; i ++){
            if (i == type) continue;
            dfs(i, count - 1, nextSet);
        }
    }
}