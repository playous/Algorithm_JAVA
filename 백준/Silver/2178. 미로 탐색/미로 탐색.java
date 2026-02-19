import java.util.*;
import java.io.*;

public class Main {
    
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static class Node {
		int r;
		int c;
		Node (int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[n][m];
        int[][] visited = new int[n][m];
        
        for (int i = 0 ; i < n ; i ++) {
        	String line = br.readLine();
        	for (int j = 0; j < m ; j ++) {
        		map[i][j] = line.charAt(j) - '0';
        		visited[i][j] = Integer.MAX_VALUE;
        	}
        }
        
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0,0));
        visited[0][0] = 1;
        
        while (!q.isEmpty()) {
        	Node cur = q.poll();
        	int cr = cur.r;
        	int cc = cur.c;
        	int time = visited[cr][cc];
        	
        	for (int i = 0 ; i < 4 ; i++) {
        		int nr = cr + dr[i];
        		int nc = cc + dc[i];
        		if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
        			if (map[nr][nc] == 1 && visited[nr][nc] > time + 1) {
        				visited[nr][nc] = time + 1;
        				q.add(new Node(nr, nc));
        			}
        		}
        	}
        }
        
        System.out.print(visited[n - 1][m - 1]);
    }
}