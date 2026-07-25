import java.util.*;

class Solution {
    class Node{
        int next;
        int weight;
        Node(int next, int weight){
            this.next = next;
            this.weight = weight;
        }
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List<Node>[] list = new List[N + 1];
        
        for (int i = 1; i <= N ; i++){
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < road.length; i ++){
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[1] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        
        pq.add(new Node(1, 0));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int id = cur.next;
            int w = cur.weight;
            
            if (dist[id] < w) continue;
            
            for (Node next : list[id]){
                if (dist[next.next] > next.weight + w){
                    dist[next.next] = next.weight + w;
                    pq.add(new Node(next.next, dist[next.next]));
                }
            }
        }
        
        for (int i = 1; i <= N ; i ++){
            if(dist[i] <= K) answer++;
        }
        return answer;
    }
}