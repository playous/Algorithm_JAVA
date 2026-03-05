import java.util.*;
import java.io.*;

public class Main {
	
	static int n, l;
	static int[][] map;
	
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		
		map = new int[n + 1][n + 1];
		
		for (int i = 1 ; i <= n ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		// 행
		
		int answer = 0;
		
		for (int i = 1 ; i <= n ; i ++) {
			arr = map[i];
			visited = new boolean[n + 1];
			int j= 1;
			
			for (j+= 1 ; j <= n ; j ++) {
				int diff = arr[j] - arr[j-1];

				
				if (diff == 0) continue;
				
				if (diff == 1) {
					if (!calc1(j)) break; 
				}
				else if(diff == -1) {
					if (!calc2(j)) break; 
					j += (l -1);
				}
				else break;
			}
			if (j == n + 1) {
				answer++;
			}
		}
		
		
		
		// 열
		for (int j = 1 ; j <= n ; j ++) {
			arr = new int[n + 1];
			
			
			for (int i = 1; i <= n ; i++) {
				arr[i] = map[i][j];
			}
			
			visited = new boolean[n + 1];
			int i= 1;
			int prev = arr[j];
			
			for (i += 1 ; i <= n ; i ++) {
				int diff = arr[i] - arr[i-1];
				
				if (diff == 0) continue;
				
				if (diff == 1) {
					if (!calc1(i)) break; 
				}
				else if(diff == -1) {
					if (!calc2(i)) break; 
					i += (l -1);
				}
				else break;
			}
			if (i == n + 1) {
				answer++;
			}
		}
		
		System.out.println(answer);
		
	}
	
	static boolean calc1(int cur) {
		if (cur - l < 1) return false;
		
		for (int i = cur - l ; i <= cur - 1; i ++) {
			if(visited[i]) {
				return false;
			}
			visited[i] = true;
		}
		return true;
	}
	
	static boolean calc2(int cur) {
		if (cur + l > n + 1) return false;
		
		int curH = arr[cur];
		
		for (int i = cur; i < cur + l; i ++) {
			if (arr[i] != curH) return false;
			visited[i] = true;
		}
		return true;
	}
	
}