import java.util.*;
import java.io.*;

public class Main {
	static int n, m, d;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		
		for (int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		
		for (int a = 0 ; a < m ; a ++) {
			for (int b = a + 1 ; b < m ; b++) {
				for (int c = b + 1; c < m ; c++) {
					visited = new boolean[n][m];
					answer = Math.max(calc(a, b, c, map) , answer);
				}
			}
		}
	
		System.out.println(answer);
		
	}
	
	public static int calc(int a, int b , int c, int[][] map) {
		int num = 0;
		for (int i = 0 ; i < n ; i ++) {
			int start = n - i - 1;

			int ar = -1;
			int ac = -1;
			int br = -1;
			int bc = -1;
			int cr = -1;
			int cc = -1;
			int disA = 10000;
			int disB = 10000;
			int disC = 10000;
			
			for (int j = start; j > start - d  && j >= 0; j --) {
				for (int q = 0; q < m ; q ++) {
					if(map[j][q] == 1 && !visited[j][q]) {
						int dA = canRemove(n - i, a,  j , q);
						int dB = canRemove(n - i, b, j , q);
						int dC = canRemove(n - i, c, j , q);
						
						if(disA > dA || disA == dA && q < ac) {
							ar = j;
							ac = q;
							disA = dA;
						}
						
						if(disB > dB || disB == dB && q < bc) {
							br = j;
							bc = q;
							disB = dB;
						}
						if(disC > dC || disC == dC && q < cc) {	
							cr = j;
							cc = q;
							disC = dC;
						}
						
					}
				}
			}
			
			if(disA != 10000 && !visited[ar][ac]) {
				visited[ar][ac] = true;
				num++;
			}
			if(disB != 10000 && !visited[br][bc]) {
				visited[br][bc] = true;
				num++;
			}
			if(disC != 10000 && !visited[cr][cc]) {
				visited[cr][cc] = true;
				num++;
			}
		}
		
		
		return num;
	}
	
	public static int canRemove(int ar, int ac, int r , int c) {
		int dis = Math.abs(r - ar) + Math.abs(c - ac);
		if (dis > d) return 10000;
		return dis;
	}
}
