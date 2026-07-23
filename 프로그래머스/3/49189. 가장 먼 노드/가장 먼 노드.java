import java.util.*;

class Solution {
    class Node{
        int id;
        int level;
        Node(int id, int level){
            this.id = id;
            this.level = level;
        }
    }
    public int solution(int n, int[][] edge) {
        List<Integer>[] graph = new List[n + 1];
        
        boolean[] visited = new boolean[n + 1];
        int[] level = new int[20000];
        
        for (int i = 1 ; i <= n ; i ++){
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edge.length ; i ++){
            int a = edge[i][0];
            int b = edge[i][1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        Queue<Node> q = new ArrayDeque<>();
        
        int max = 0;
        
        q.add(new Node(1, 0));
        visited[1] = true;
        
        while (!q.isEmpty()){
            Node cur = q.poll();
            level[cur.level]++;
            
            max = Math.max(max, cur.level);
            
            for (int next : graph[cur.id]){
                if (!visited[next]){
                    visited[next] = true;
                    q.add(new Node(next, cur.level + 1));
                }
            }
        }
        
        return level[max];
    }
    
}