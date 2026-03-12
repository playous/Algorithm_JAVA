import java.util.*;
import java.io.*;

public class Solution {	
	
	static int answer;
	static int n, w, h;
	static int[][] map;
	
	static int[] height;
	static boolean[][] visited;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static List<Integer> list;
	
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
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T ; t++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			map = new int[h + 1][w + 1];
			height = new int[w + 1];
		
			for (int i = 1 ; i <= h ; i ++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= w; j ++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (height[j] == 0 && map[i][j] != 0) {
						height[j] = i; 
					}
				}
			}
			
			list = new ArrayList<>();
			answer = Integer.MAX_VALUE;
			calc(0);
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	public static void calc(int cnt) {
		if (cnt == n) {
			int[][] cMap = new int[h + 1][w + 1];
			int[] hArr = height.clone();
		
			for (int i = 1; i <= h; i ++) {
				cMap[i] = map[i].clone();
			}
			
			calc2(cMap, hArr);
			return;
		}
		
		for (int i = 1 ; i <= w ; i ++) {
			list.add(i);
			calc(cnt + 1);
			list.remove(list.size() - 1);
		}
	}
	
	public static void calc2(int[][] map, int[] hArr) {
		for (int i = 0 ; i < n ; i ++) {
			visited = new boolean[h + 1][w + 1];
			int sc = list.get(i);
			int sr = hArr[sc];
			if (sr == 0) continue;
			calc3(map, sr, sc);
			calc4(map, hArr);
		}
		answer = Math.min(calc5(map), answer);
	}
	
	public static void calc3(int[][] map, int r, int c) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(r, c));
		visited[r][c] = true;
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			int cr = cur.r;
			int cc = cur.c;
			int power = map[cr][cc];
			for (int p = 1 ; p <= power - 1; p ++) {
				for (int i = 0; i < 4 ; i ++) {
					int nr = cr + (dr[i] * p);
					int nc = cc + (dc[i] * p);
					
					if (nr >= 1 && nc >= 1 && nr <= h && nc <= w) {
						if (!visited[nr][nc] && map[nr][nc] != 0) {
							visited[nr][nc] = true;
							if (map[nr][nc] > 1) {
								q.add(new Node(nr, nc));
							}
						}
					}
				}
			}
		}
	}
	
	public static void calc4(int[][] map, int[] hArr) {
		for (int col = 1; col <= w ; col ++) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int row = h ; row >= 1 ; row --) {
				if (!visited[row][col] && map[row][col] != 0) {
					list.add(map[row][col]);
				}
				map[row][col] = 0;
			}
			
			int idx = h;
			hArr[col] = 0;
			
			for (int num : list) {
				map[idx][col] = num;
				idx--;
			}
			hArr[col] = list.isEmpty() ? 0 : idx + 1;
		}
	}
	
	public static int calc5(int[][] map) {
		int cnt = 0;
		for (int i = 1 ; i <= h ; i ++) {
			for (int j = 1; j <= w ; j++) {
				if (map[i][j] != 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}