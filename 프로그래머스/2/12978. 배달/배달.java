import java.util.*;

class Solution {
    static class Node{
        int num;
        int cost;
        Node(int num, int cost){
            this.num = num;
            this.cost = cost;
        }
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 1;
        int[][] map = new int[N + 1][N + 1];
        boolean[] visited = new boolean[N + 1];
        
        for (int i = 0 ; i < N + 1 ; i ++){
            for (int j = 0 ; j < N + 1 ; j++){
                map[i][j] = 1000000;
            }
        }
        
        for (int i = 0 ; i < road.length; i ++){
            int s1 = road[i][0];
            int s2 = road[i][1];
            int cost = road[i][2];
            map[s1][s2] = Math.min(map[s1][s2], cost);
            map[s2][s1] = Math.min(map[s2][s1], cost);
        }
      
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        
        for(int i = 2 ; i < N + 1 ; i ++){
            if(map[1][i] <= K){
                pq.add(new Node(i, map[1][i]));
            }
        }
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if (visited[cur.num]) continue;
            if(cur.cost > K) break;
            else {
                visited[cur.num] = true;
                answer++;
            }
            for (int i = 2; i < N + 1 ; i++){
                if(!visited[i] && map[cur.num][i] + cur.cost <= K){
                    pq.add(new Node(i, map[cur.num][i] + cur.cost));
                }
            }
        }
        return answer;
    }
}