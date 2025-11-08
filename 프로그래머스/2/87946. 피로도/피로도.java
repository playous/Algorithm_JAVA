import java.util.*;

class Solution {
    static int answer = 0;
    static int len;
    
    public int solution(int k, int[][] dungeons) {
        len = dungeons.length;
        boolean[] visited = new boolean[len];
        
        backTrack(dungeons, visited, k, 0);
        
        return answer;
    }
    
    static void backTrack(int[][] dungeons, boolean[] visited, int remain, int count){
        answer = Math.max(answer, count);
        
        for (int i = 0 ; i < len ; i++){
            if(!visited[i] && dungeons[i][0] <= remain){
                System.out.println(i);
                visited[i] = true;
                backTrack(dungeons, visited, remain - dungeons[i][1], count + 1);
                visited[i] = false;
            }
        }
        
    }
}