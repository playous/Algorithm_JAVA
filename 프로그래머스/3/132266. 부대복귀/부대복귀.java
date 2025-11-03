import java.util.*;
import java.io.*;

class Solution {
    static class Node {
        int name;
        int t;
        Node(int name, int t){
            this.name = name;
            this.t = t;
        }
    }
    public int[] solution(int n, int[][] roads, int[] sources, int des) {
        List<Integer>[] list = new List[n+1];
        int road_count = roads.length;
        
        for (int i = 1 ; i <= n ; i++){
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < road_count; i ++){
            int a = roads[i][0];
            int b = roads[i][1];
            list[a].add(b);
            list[b].add(a);
        }
        
        int[] time = new int[n+1];
        boolean[] visited = new boolean[n+1];
        
        Arrays.fill(time,Integer.MAX_VALUE);
 
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.t - b.t);
        pq.add(new Node(des,0));
        visited[des] = true;
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int name = cur.name;
            int t = cur.t;
            time[name] = t;
            
            for (int next : list[name]){
                if (!visited[next]){
                    visited[next] = true;
                    pq.add(new Node(next, t + 1));
                }
            }
        }
        
        int[] answer = new int[sources.length];
        
        for (int i = 0; i < sources.length ; i ++){
            answer[i] = time[sources[i]] == Integer.MAX_VALUE ? -1 : time[sources[i]];
        }
             
        return answer;
    }
}