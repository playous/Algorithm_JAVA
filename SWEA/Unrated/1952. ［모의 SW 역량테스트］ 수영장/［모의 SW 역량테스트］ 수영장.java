import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	int[] cost = new int[4];
        	
        	st = new StringTokenizer(br.readLine());
        	
        	for (int i = 0 ; i < 4 ; i++) {
        		cost[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	int[] days = new int[13];
        	
        	int[] dp = new int[13];
        	
        	st = new StringTokenizer(br.readLine());
        	for(int i = 1; i <= 12 ; i ++) {
        		days[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	for (int i = 1; i <= 12 ; i ++) {
        		dp[i] = dp[i - 1] + Math.min(cost[0] * days[i], cost[1]);
        		
        		if (i >= 3) {
        			dp[i] = Math.min(dp[i], dp[i - 3] + cost[2]);
        		}
        	}
        	 
        	dp[12] = Math.min(cost[3], dp[12]);
        	System.out.println("#" + t + " " + dp[12]);
		}
	}
}
