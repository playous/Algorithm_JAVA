import java.util.*;
import java.io.*;

class Solution{
	static int n;
	static int[][] map;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int[] answer;
	
	static List<Node> cores;
	static int coreCnt;
	
	static class Node{
		int r;
		int c;
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	
        	n = Integer.parseInt(br.readLine());
        	
        	map = new int[n][n];
        	boolean[][] visited = new boolean[n][n];
        	cores = new ArrayList<>();
        	
        	
        	for (int i = 0; i < n ; i ++) {
        		st = new StringTokenizer(br.readLine());
        		for (int j = 0; j < n ; j ++) {
        			map[i][j] = Integer.parseInt(st.nextToken());
        			if (map[i][j] == 1) {
        				if(i != 0 && j != 0 && i != n -1 && j != n - 1) {
        					cores.add(new Node(i,j));
        				}
        				visited[i][j] = true;
        			}
        		}
        	}
        	coreCnt = cores.size();
        	
        	answer = new int[coreCnt + 1];
        	Arrays.fill(answer, Integer.MAX_VALUE);
        	
        	dfs(0, 0, 0, visited);
        	
        	int answerCount = 0;
        	
        	for (int i = 1 ; i <= coreCnt ; i++) {
        		if(answer[i] == Integer.MAX_VALUE) break;
        		answerCount = answer[i];
        	}
        	
        	sb.append("#").append(t).append(" ").append(answerCount).append("\n");
		}
        
        System.out.println(sb.toString());
        
	}
	
	public static void dfs(int idx, int cnt, int sum, boolean[][] visited) {	
		answer[cnt] = Math.min(answer[cnt], sum);
		
		if (idx == coreCnt) return;
		
		Node cur = cores.get(idx);
		int curR = cur.r;
		int curC = cur.c;
		
		boolean[][] save = new boolean[n][n];
		
		for (int i = 0 ; i < n ; i ++) {
			save[i] = visited[i].clone();
		}
		
		
		for (int i = 0; i < 5 ; i ++) {
			if (i == 4) {
				dfs(idx + 1, cnt, sum, visited);
				continue;
			}
			
			int len = calc(curR, curC, i, visited);
			
			if (len == -1) continue;
			
			dfs(idx+1, cnt + 1, sum + len, visited);
			
			for (int j = 0; j < n; j++) {
			    visited[j] = save[j].clone();
			}
		}
		
	}
	
	public static int calc(int r, int c, int dirc, boolean[][] visited) {
		int nextR = r;
		int nextC = c;
		int count = 0;
		
		while(true) {
			nextR += dr[dirc];
			nextC += dc[dirc];
			
			if (nextR == 0 || nextC == 0 || nextR == n - 1 || nextC == n - 1) {
				if (visited[nextR][nextC]) return -1;
				break;
			}
			
			if (visited[nextR][nextC]) {
				return -1;
			}
		}
		
		int minR = Math.min(nextR, r);
		int maxR = Math.max(nextR, r);
		
		int minC = Math.min(nextC, c);
		int maxC = Math.max(nextC, c);
		
		for (int i = minR; i <= maxR ; i++) {
			visited[i][c] = true;
			count++;
		}
		for (int j = minC; j <= maxC; j++) {
			visited[r][j] = true;
			count++;
		}
		
		return count - 2;
	}

}