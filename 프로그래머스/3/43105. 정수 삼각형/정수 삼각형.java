class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length + 1;
        int[][] dp = new int[len][len];
        dp[1][1] = triangle[0][0];
        
        for (int i = 2; i < len ; i++){
            for (int j = 1; j <= i ; j++){
                int a = Math.max(dp[i-1][j-1],dp[i-1][j]);
                dp[i][j] = Math.max(dp[i][j], triangle[i-1][j-1] + a);
            }
        }
        
        for (int j = 1; j < len ; j++){
            if(dp[len-1][j] > answer) answer = dp[len-1][j];
        }
        return answer;
    }
}