class Solution {
    int MOD = 20170805;
    
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] dp = new int[m + 1][n + 1][2];
        
        dp[1][1][0] = 1;
        dp[1][1][1] = 1;
        
        for (int j = 2; j <= n; j++) {
            if (cityMap[0][j - 2] == 1) break;
            dp[1][j][1] = dp[1][j - 1][1];
        }
        
        for (int i = 2; i <= m; i++) {
            if (cityMap[i - 2][0] == 1) break;
            dp[i][1][0] = dp[i - 1][1][0];
        }
        
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                if (cityMap[i - 1][j - 1] == 1) continue;
                
                if (cityMap[i - 2][j - 1] == 0) {
                    dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;
                } else if (cityMap[i - 2][j - 1] == 2) {
                    dp[i][j][0] = dp[i - 1][j][0];
                }
                
                if (cityMap[i - 1][j - 2] == 0) {
                    dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % MOD;
                } else if (cityMap[i - 1][j - 2] == 2) {
                    dp[i][j][1] = dp[i][j - 1][1];
                }
            }
        }
        
        return (dp[m][n][0] + dp[m][n][1]) % MOD;
    }
}