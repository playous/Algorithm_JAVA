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
			int n = Integer.parseInt(br.readLine());;
			int answer = 1;
			for (int i = 2; i * i <= n ; i++) {
				int cnt = 2;
				while (n % i == 0) {
					n /= i;
					cnt ++;
				}
				if (cnt % 2 == 1) {
					answer *= i;
				}
			}
			if (n > 1 ) answer *= n;
			
			sb.append("#").append(T).append(" ").append(answer).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
}