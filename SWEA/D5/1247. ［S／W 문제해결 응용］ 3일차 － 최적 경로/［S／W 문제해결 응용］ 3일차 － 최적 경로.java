import java.util.*;
import java.io.*;

public class Solution {

	static int n;
	static int answer;
	static boolean[] visited;
	static Node[] nodes;
	
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T ; t++) {
			n = Integer.parseInt(br.readLine());
			answer = Integer.MAX_VALUE;
			nodes = new Node[n + 2];
			visited = new boolean[n + 2];
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0 ; i < n + 2 ; i ++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				nodes[i] = new Node(x, y);
			}
			
			calc(0, 0, 0);
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
			
		}
		System.out.print(sb.toString());
		

	}
	
	public static void calc(int last, int sum, int cnt) {
		if(cnt == n) {
			sum += getDis(last, 1);
			answer = Math.min(answer, sum);
			return;
		}
		
		for (int i = 2 ; i <= n + 1 ; i ++) {
			if (!visited[i]) {
				visited[i] = true;
				calc(i, sum + getDis(last, i), cnt + 1);
				visited[i] = false;
			}
		}
	}
	
	public static int getDis(int a, int b) {
		return Math.abs(nodes[a].x - nodes[b].x) + Math.abs(nodes[a].y - nodes[b].y);
	}

}
