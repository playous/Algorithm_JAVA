import java.util.*;
import java.io.*;

public class Solution {
	
	public static boolean[] visited;
	public static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1 ; t <= T ; t++) {
			n = Integer.parseInt(br.readLine());
			
			m = Integer.parseInt(br.readLine());
			
			// 정방향
			List<Integer>[] list1 = new List[n + 1];
			
			// 역방향
			List<Integer>[] list2 = new List[n + 1];
		
			for (int i = 1 ; i <= n ; i ++) {
				list1[i] = new ArrayList<>();
				list2[i] = new ArrayList<>();
			}
			
			for (int i = 0 ; i < m ; i ++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list1[a].add(b);
				list2[b].add(a);
			}
			
			int answer = 0;
			
			for (int i = 1; i <= n ; i++) {
				
				// 나보다 큰 사람 + 작은사람 
				visited = new boolean[n + 1];
				
				bfs(list1, i);
				bfs(list2, i);
				
				int cnt = 0;
				
				for (int j = 1 ; j <= n ; j ++) {
					if (i == j) continue;
					if (visited[j]) cnt ++;
				}
				
				if (cnt == n - 1) answer++;
				
			}
			
			
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	public static void bfs(List<Integer>[] list, int idx) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(idx);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for (int next : list[cur]) {
				if (!visited[next]) {
					q.add(next);
					visited[next] = true;
				}
			}	
		}
	}
}