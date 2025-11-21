import java.util.*;
import java.io.*;

public class Solution {
	static boolean[] visited;
	static int n, m;
	static List<Integer>[] list;
	static int answer;
	static class Node {
		int num;
		int level;
		Node(int num, int level){
			this.num = num;
			this.level = level;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
	
		for (int T = 1 ; T <= t ; T ++) {
			answer = 1;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			list = new List[n + 1];
			for (int i = 1; i <= n ; i ++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0 ; i < m ; i ++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			
			for (int i = 1 ; i <= n ; i ++) {
				visited = new boolean[n+1];
				visited[i]= true;
				dfs(i, 1);
			}
			sb.append("#").append(T).append(" ").append(answer).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void dfs(int cur, int count) {
		answer = Math.max(count, answer);
		for (int next : list[cur]) {
			if (!visited[next]) {
				visited[next] = true;
				dfs(next, count + 1);
				visited[next] = false;
			}
		}
	}
	
}
