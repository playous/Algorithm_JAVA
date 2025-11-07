import java.util.*;

class Solution {
    static class Node{
        int end;
        int cost;
        Node(int end, int cost){
            this.end = end;
            this.cost = cost;
        }
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        List<Node>[] list = new List[n];
        
        for (int i = 0 ; i < n ; i ++){
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < costs.length; i ++){
            int a = costs[i][0];
            int b = costs[i][1];
            int c = costs[i][2];
            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        
        boolean[] visited = new boolean[n];
        for (Node node : list[0]){
            pq.add(node);
        }
        visited[0] = true;
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int next = cur.end;
            int cost = cur.cost;
            if (!visited[next]){
                visited[next] = true;
                answer += cost;
            }
            
            for (Node node : list[next]){
                if (!visited[node.end]){
                    pq.add(node);
                }
            }
            
        }
        
        return answer;
    }
}