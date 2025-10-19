class Solution {
    public int solution(int[] money) {
        int len = money.length;
        int[] dp = new int[len + 1];
        
        dp[0] = 0;
        dp[1] = money[0];
        // 첫번째 집 선택
        for (int i = 2 ; i < len ; i ++){
            dp[i] = Math.max(dp[i-2] + money[i - 1], dp[i-1]);
        }
        dp[len] = dp[len-1];
        
        int[] dp1 = new int[len + 1];
        
        dp1[0] = 0;
        dp1[1] = 0;
        // 첫번째 집 선택X
        for (int i = 2 ; i <= len ; i ++){
            dp1[i] = Math.max(dp1[i-2] + money[i - 1], dp1[i-1]);
        }
        return Math.max(dp[len], dp1[len]);
    }
}