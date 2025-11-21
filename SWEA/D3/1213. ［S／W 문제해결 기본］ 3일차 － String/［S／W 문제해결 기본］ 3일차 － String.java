import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
	
		for (int T = 1 ; T <= 10 ; T ++) {
			int answer = 0;
			int n = Integer.parseInt(br.readLine());
			String s = br.readLine();
			int len = s.length();
			String str = br.readLine();
			for (int i = 0 ; i <= str.length() - len ; i ++) {
				if(str.substring(i,len + i).equals(s)) {
					answer++;
				}
			}
			sb.append("#").append(T).append(" ").append(answer).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
}
