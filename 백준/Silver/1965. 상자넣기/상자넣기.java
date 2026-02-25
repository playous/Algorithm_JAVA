import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n + 1];
		int[] dp = new int[n + 1];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i<= n ; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1 ; i <= n ; i ++) {
			int cur = arr[i];
			int max = 0;
			
			for (int j = 0; j < i ; j ++ ) {
				if(arr[j] < cur) {
					max = Math.max(max, dp[j] + 1);
				}
			}
			dp[i] = max;
		}
		
		int answer = 0;
		
		for (int i = 1 ; i <= n ; i ++) {
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.print(answer);
		
	}
}