import java.util.*;
import java.io.*;

public class Solution {
	
	static int n;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Node{
		int r;
		int c;
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1 ; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			
			for (int i = 0 ; i < n ; i ++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j ++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = 1;
			
			for (int i = 1 ; i <= 100 ; i ++) {
				visited = new boolean[n][n];
				answer = Math.max(answer, calc(i));
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
			
		}
		System.out.print(sb.toString());
	}
	
	public static int calc(int day) {
		int cnt = 0;
		for (int i = 0 ; i < n ; i ++) {
			for (int j = 0 ; j < n ; j ++) {
				if(map[i][j] > day && !visited[i][j]) {
					bfs(i, j, day);
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static void bfs(int r, int c, int day) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(r, c));
		visited[r][c] = true;
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			int cr = cur.r;
			int cc = cur.c;
			
			for (int i = 0; i < 4 ; i ++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
					if (map[nr][nc] > day && !visited[nr][nc]) {
						visited[nr][nc] = true;
						q.add(new Node(nr, nc));
					}
				}
			}
		}
	}
	
}