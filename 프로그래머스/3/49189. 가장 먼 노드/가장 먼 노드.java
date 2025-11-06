import java.util.*;

class Solution {
    static class Node{
        int name;
        int level;
        Node (int name, int level){
            this.name = name;
            this.level = level;
        }
    }
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<Integer>[] graph = new List[n+1];
        boolean[] visited = new boolean[n+1];
        
        for (int i = 1 ; i<= n ; i++){
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0 ; i < edge.length ; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(1,0));
        visited[1] = true;
        int max = 0;
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            int c_name = cur.name;
            int n_level = cur.level + 1;
            if (n_level == max){
                answer ++;
            }
            if (n_level > max) {
                max = n_level;
                answer = 1;
            }
            
            for (int next : graph[c_name]){
                if(!visited[next]){
                    q.add(new Node(next, n_level));
                    visited[next] = true;
                }
            }
        }
        
        return answer;
    }
}