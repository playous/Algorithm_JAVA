import java.util.*;
import java.io.*;

public class Solution {

	public static int n;
	
	public static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static List<Node> list;
	
	public static long answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1 ; t <= T ; t++) {
			n = Integer.parseInt(br.readLine());
			
			answer = Long.MAX_VALUE;
			list = new ArrayList<>();
			for (int i = 0 ; i < n ; i ++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new Node(x, y));
			}
			
			int minus = n/2;
			
			calc(minus, 0, 0, 0);
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	public static void calc(int minus, int xSum, int ySum, int idx) {
		if(idx == list.size()) {
			if(minus != 0) return;
			long v = (long) xSum * xSum + (long) ySum * ySum;
			answer = Math.min(answer, v);
			return;
		}
		
		int x = list.get(idx).x;
		int y = list.get(idx).y;
		calc(minus, xSum + x, ySum + y, idx + 1);
		calc(minus - 1, xSum - x, ySum - y, idx + 1);
	}
}