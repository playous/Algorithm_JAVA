import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        int n = signals.length;
        
        int[] len = new int[n];
        boolean[][] visited = new boolean[n][];
        
        for (int i = 0 ; i < n ; i ++){
            len[i] = signals[i][0] + signals[i][1] + signals[i][2];        
            visited[i] = new boolean[len[i]];
            
            for (int j = signals[i][0] ; j < signals[i][0] + signals[i][1]; j++){
                visited[i][j] = true;
            }
        }
        
        int answer = -1;
        
        for (int i = 0 ; i <= 3200000 ; i ++){
            boolean flag = true;
            for (int j = 0 ; j < n ; j ++){
                if(!visited[j][i % len[j]]){
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                answer = i + 1;
                break;
            }
        }
        return answer;
            
    }
}