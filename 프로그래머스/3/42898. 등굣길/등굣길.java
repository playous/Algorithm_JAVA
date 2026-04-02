import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        long[][] dp = new long[m + 1][n + 1];
        
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0 ; i < puddles.length; i ++){
            set.add(puddles[i][0] * 101 + puddles[i][1]);
        }
        
        dp[0][1] = 1;
        
        for (int i = 1 ; i <= m ; i ++){
            for (int j = 1 ; j <= n ; j++){
                int key = i * 101 + j;
                if (set.contains(key)) continue;
                
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
            }
        }
        
        
        return (int)dp[m][n];
    }
}