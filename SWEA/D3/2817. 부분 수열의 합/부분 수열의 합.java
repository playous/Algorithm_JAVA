import java.util.*;
import java.io.*;

public class Solution {
	static int answer = 0, n, k;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
	
		for (int T = 1 ; T <= t ; T ++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			arr = new int[n];
			answer = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n ; i ++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			calc(0 , 0);
			sb.append("#").append(T).append(" ").append(answer).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void calc(int s, int sum) {
		if (sum == k) {
			answer ++;
		}
		for (int i = s ; i < n ; i ++) {
			calc(i + 1, sum + arr[i]);
		}
	}
}

