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
			int answer = 0;
			int n = Integer.parseInt(br.readLine());
	
			int[] count = new int[5001];
			
			for (int i = 0 ; i < n ; i ++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				for (int j = a; j <= b; j++) {
					count[j]++;
				}
			}
			
			sb.append("#").append(T);
			
			int p = Integer.parseInt(br.readLine());
			for (int i = 0 ; i < p ; i ++) {
				int c = Integer.parseInt(br.readLine());
				sb.append(" ").append(count[c]);
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
}
