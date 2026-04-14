import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int maxA = 0;
        int maxC = 0;
        
        for (int[] p : problems) {
            maxA = Math.max(maxA, p[0]);
            maxC = Math.max(maxC, p[1]);
        }
        
        alp = Math.min(alp, maxA);
        cop = Math.min(cop, maxC);
        
        int[][] dp = new int[maxA + 1][maxC + 1];
        
        for (int i = 0; i <= maxA; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        dp[alp][cop] = 0;
        
        for (int a = alp; a <= maxA; a++) {
            for (int c = cop; c <= maxC; c++) {
                if (dp[a][c] == Integer.MAX_VALUE) continue;
                
                if (a + 1 <= maxA) {
                    dp[a + 1][c] = Math.min(dp[a + 1][c], dp[a][c] + 1);
                }
                
                if (c + 1 <= maxC) {
                    dp[a][c + 1] = Math.min(dp[a][c + 1], dp[a][c] + 1);
                }
                
                for (int[] p : problems) {
                    int reqA = p[0];
                    int reqC = p[1];
                    int rwdA = p[2];
                    int rwdC = p[3];
                    int cost = p[4];
                    
                    if (a >= reqA && c >= reqC) {
                        int nextA = Math.min(maxA, a + rwdA);
                        int nextC = Math.min(maxC, c + rwdC);
                        
                        dp[nextA][nextC] = Math.min(dp[nextA][nextC], dp[a][c] + cost);
                    }
                }
            }
        }
        
        return dp[maxA][maxC];
    }
}