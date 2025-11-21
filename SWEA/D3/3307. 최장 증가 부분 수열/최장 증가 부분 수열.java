import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
	
		for (int T = 1 ; T <= t ; T ++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			int[] dp = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0 ; i < n ; i ++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int answer = 1;
			dp[0] = 1;
			for (int i = 1; i < n ; i ++) {
				int cur = arr[i];
				dp[i] = 1;
				for (int j = 0 ; j < i ; j ++) {
					if (arr[j] < cur) {
						dp[i] = Math.max(dp[j] + 1, dp[i]); 
					}
				}
				answer = Math.max(answer, dp[i]);
			}

			sb.append("#").append(T).append(" ").append(answer).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
}