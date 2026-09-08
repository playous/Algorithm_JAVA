import java.util.*;

class Solution {
    boolean[] visited;
    int len;
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        len = dungeons.length;
        visited = new boolean[len];
        calc (k, 0, dungeons);
        return answer;
    }
    
    public void calc(int remain, int count, int[][] dungeons){
        answer = Math.max(answer, count);
        for (int i = 0 ; i < len ; i ++){
            if (!visited[i] && remain >= dungeons[i][0]){
                visited[i] = true;
                calc(remain - dungeons[i][1], count + 1, dungeons);
                visited[i] = false;
            }
        }
    }
}