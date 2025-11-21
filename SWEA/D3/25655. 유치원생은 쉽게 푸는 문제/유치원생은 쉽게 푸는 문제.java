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
			if (n == 1) sb.append(0);
			else {
				if (n % 2 == 0) {
					for (int i = 0 ; i < n/2 ; i ++) {
						sb.append(8);
					}
				}
				else {
					sb.append(4);
					for (int i = 0; i < n /2; i++) {
						sb.append(8);
					}
				}
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
}

