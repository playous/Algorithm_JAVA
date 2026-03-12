import java.util.*;
import java.io.*;

public class Solution {	
	
	static int[][] map;
	
	static HashSet<Integer>[][][] set;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T ; t++) {
			
			map = new int[4][4];
			
			set = new HashSet[8][4][4];
			
			for (int i = 1; i <= 7 ; i ++) {
				for (int r = 0 ; r < 4 ; r ++) {
					for (int c = 0 ; c < 4 ; c ++) {
						set[i][r][c] = new HashSet<>();
					}
				}
			}
			
			for (int i = 0 ; i < 4 ; i ++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4 ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					set[1][i][j].add(map[i][j]);
				}
			}
			
			
			for (int i = 2; i <= 7 ; i ++) {
				calc(i);
			}
			
			HashSet<Integer> answer = new HashSet<>();
			for (int i = 0 ; i < 4 ; i ++) {
				for (int j = 0 ; j < 4 ; j ++) {
					for (int num : set[7][i][j]) {
						answer.add(num);
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(answer.size()).append("\n");
			
		}
		System.out.print(sb.toString());
		

	}
	
	public static void calc(int k) {
		for (int i = 0 ; i < 4 ; i ++) {
			for (int j = 0 ; j < 4 ; j ++) {
				calc2(k, i, j);
			}
		}
	}
	
	public static void calc2(int k, int r, int c) {
		int curNum = map[r][c] * (int)Math.pow(10, k - 1);
		
		for (int i = 0 ; i < 4 ; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr >= 0 && nc >= 0 && nr < 4 && nc < 4) {
				for (int num : set[k - 1][nr][nc]) {
					set[k][r][c].add(curNum + num);
				}
			}
		}
	}
	
}
