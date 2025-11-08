import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 1000;
        
        int len = wires.length;
        List<Integer>[] list = new List[n + 1];
        for (int i = 1 ; i <= n ; i ++){
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0 ; i < len ; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            list[v1].add(v2);
            list[v2].add(v1);
        }
        
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new ArrayDeque<>();
        
        for (int i = 0 ; i < len ; i++){
            int count = 1;
            
            Arrays.fill(visited, false);
            
            visited[wires[i][0]] = true;
            q.add(wires[i][1]);
            visited[wires[i][1]] = true;
            
            while(!q.isEmpty()){
                int cur = q.poll();
                for (int next : list[cur]){
                    if(!visited[next]){
                        q.add(next);
                        visited[next] = true;
                        count++;
                    }
                }
            }
            int remain = n - count;
            
            if (Math.abs(remain - count) < answer){
                answer = Math.abs(remain -count);
            }
            
        }
        return answer;
    }
}