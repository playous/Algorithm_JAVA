import java.util.*;

// dp?


class Solution {
    public int[] solution(int target) {
        int[] answer = new int[2];
        
        int[][] dp = new int[100001][2];
    
        
        for (int i = 1 ; i <= 100000; i ++){
            dp[i][0] = Integer.MAX_VALUE - 2;
        }
        
        int cnt = 1;
        for (int i = 50; i <= 100000; i += 50){
            dp[i][0] = cnt;
            dp[i][1] = cnt;
            cnt++;
        }
        
        for (int i = 1; i <= 20 ; i++){
            
            for (int j = 0; j <= 100000 - i; j++){
                if (dp[j + i][0] > dp[j][0] + 1){
                    dp[j + i][0] = dp[j][0] + 1;
                    dp[j + i][1] = dp[j][1] + 1;
                }
                else if(dp[j + i][0] == dp[j][0] + 1){
                    dp[j + i][1] = Math.max(dp[j][1] + 1, dp[j + i][1]);
                }
                             
            }

            for (int j = 0; j <= 100000 - (i * 2); j++){
                if (dp[j + (i * 2)][0] > dp[j][0] + 1){
                    dp[j + (i * 2)][0] = dp[j][0] + 1;
                    dp[j + (i * 2)][1] = dp[j][1];   
                }
                else if(dp[j + (i * 2)][0] == dp[j][0] + 1){
                    dp[j + (i * 2)][1] = Math.max(dp[j][1], dp[j + (i * 2)][1]);
                }
            }

            for (int j = 0; j <= 100000 - (i * 3); j++){
                if (dp[j + (i * 3)][0] > dp[j][0] + 1){
                    dp[j + (i * 3)][0] = dp[j][0] + 1;
                    dp[j + (i * 3)][1] = dp[j][1];   
                }
                else if(dp[j + (i * 3)][0] == dp[j][0] + 1){
                    dp[j + (i * 3)][1] = Math.max(dp[j][1], dp[j + (i * 3)][1]);
                }
            }
            
        }
        
        answer[0] = dp[target][0];
        answer[1] = dp[target][1];
        
        return answer;
    }
}