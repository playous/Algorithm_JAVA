import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1 ; t <= T ; t++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[n][n];
		
			
			for (int i = 0; i < n ; i ++) {
				for (int j = 0 ; j < n ; j ++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if(map[i][j] == 0) map[i][j] = 100000000;
				}
			}
			
			for (int k = 0; k < n ; k ++) {
				for (int i = 0 ; i < n ; i ++) {
					for (int j = 0 ; j < n ; j ++) {
						if (i == j) continue;
						map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
					}
				}
			}
			
			int answer = 100000000;
			
			
			for (int i = 0; i < n ; i ++) {
				int sum = 0;
				for (int j = 0 ; j < n ; j ++) {
					if (i == j) continue;
					sum += map[i][j];
				}
				answer = Math.min(answer, sum);
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}