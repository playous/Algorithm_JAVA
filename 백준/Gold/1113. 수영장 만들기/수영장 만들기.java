import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m, answer;
	static int[][] map;
	static boolean[][] visited;
	
	static boolean canPlus;
	
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
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		
		for (int i = 0 ; i < n ; i ++) {
			String line = br.readLine();
			for (int j = 0 ; j < m ; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		for (int target = 1; target < 9 ; target++) {
			for (int i = 0; i < n ; i ++) {
				for (int j = 0; j < m ; j ++) {
					if(map[i][j] == target) {
						canPlus = true;
						bfs(i, j , target);
					}
				}
			}
		}
		
		System.out.println(answer);
	}
	
	public static void bfs(int r, int c, int target) {
		Queue<Node> q = new ArrayDeque<>(); 
		q.add(new Node(r,c));
		visited = new boolean[n][m];
		
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for (int i = 0; i < 4 ; i ++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
					if(map[nr][nc] <= target && !visited[nr][nc]) {
						q.add(new Node(nr, nc));
						visited[nr][nc] = true;
					}
				}
				
				else {
					canPlus = false;
					q.clear();
					break;
				}
			}
		}
		
		if (canPlus) {
			for (int i = 0 ; i < n ; i ++) {
				for (int j = 0 ; j < m ; j ++) {
					if (visited[i][j]) {
						map[i][j]++;
						answer++;
					}
				}
			}
		}
	}
}