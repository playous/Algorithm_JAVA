import java.util.*;
import java.io.*;

public class Main {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int n, m;
	static int[][] map;
	static int[][] dp;
	static boolean[][] visited; 
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n + 1][m + 1];
		dp = new int[n + 1][m + 1];
		visited = new boolean[n + 1][m + 1];
		
		for (int i = 1; i <= n; i++) {
			String line = br.readLine();
			for (int j = 1; j <= m; j++) {
				char c = line.charAt(j - 1);
				if (c == 'H') {
					map[i][j] = -1;
				} else {
					map[i][j] = c - '0';
				}
			}
		}
		
		System.out.println(calc(1, 1));
	}
	
	public static int calc(int r, int c) {
		
		if (r < 1 || c < 1 || r > n || c > m || map[r][c] == -1) {
			return 0;
		}
		
		if (visited[r][c]) {
			System.out.println(-1);
			System.exit(0);
		}
		
		if (dp[r][c] != 0) {
			return dp[r][c];
		}
		
		visited[r][c] = true;
		
		int cnt = map[r][c];
		int maxNum = 0;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i] * cnt;
			int nc = c + dc[i] * cnt;
			
			maxNum = Math.max(maxNum, calc(nr, nc) + 1);
		}
		
		visited[r][c] = false; 
		dp[r][c] = maxNum;
		
		return dp[r][c];
	}
}