import java.util.*;
import java.io.*;

class Solution {
	static int n, sum, answer;
	static boolean[] teamA;
	static int[][] map;
	
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1 ; t <= T ; t++) {
        	n = Integer.parseInt(br.readLine());
        	
        	map = new int[n + 1][n + 1];
        	
        	for (int i = 1; i <= n ; i ++) {
        		st = new StringTokenizer(br.readLine());
        		for (int j = 1; j <= i ; j ++) {
        			map[j][i] += Integer.parseInt(st.nextToken());
        		}
        		for (int j = i + 1; j <= n ; j++) {
        			map[i][j] += Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	
        	sum = 0;
        	answer = Integer.MAX_VALUE;
        	
        	teamA = new boolean[n + 1];
    
        	backTrack(1, 0);
            
            
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.print(sb.toString());
        
	}
	
	public static void backTrack (int idx, int cnt) {
		if (cnt == n / 2) {
			int foodA = getCost(true);
			int foodB = getCost(false);
			answer = Math.min(Math.abs(foodA - foodB), answer);
			return;
		}
		for (int i = idx; i <= n ; i++) {
			teamA[i] = true;
			backTrack(i + 1, cnt + 1);
			teamA[i] = false;
		}
	}
	
	public static int getCost(boolean flag) {
		int cost = 0;
		for (int i = 1 ; i <= n ; i ++) {
			for (int j = i + 1; j <= n ; j ++) {
				if (teamA[i] == flag && teamA[j] == flag) {
					cost += map[i][j];
				}
			}
		}
		return cost;
	}
}

