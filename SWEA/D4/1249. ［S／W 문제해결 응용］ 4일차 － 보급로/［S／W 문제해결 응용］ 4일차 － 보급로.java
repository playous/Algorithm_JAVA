import java.util.*;
import java.io.*;

class Solution
{
    static int[] dc = {-1, 1, 0, 0};
    static int[] dr = {0, 0, -1, 1};
    static int answer = Integer.MAX_VALUE;
    static int n;
    
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];
            int[][] visited = new int[n][n];
            answer = Integer.MAX_VALUE;
            
            for (int i = 0; i < n ; i++){
                String s =br.readLine();
                Arrays.fill(visited[i],Integer.MAX_VALUE);
                for (int j = 0; j < n ; j++){
                    map[i][j] = s.charAt(j) -'0';
                }
            }
            int sum = 0;
            visited[0][0] = 0;
            dfs(map,visited,0,0,sum);
            
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
        bw.write(sb.toString());
        bw.flush();
	}
    static void dfs(int[][] map, int[][] visited, int curC, int curR, int sum){
        if(curC == n - 1 && curR == n -1){
            answer = Math.min(answer, sum);
        }
        for (int i = 0; i < 4; i ++){
            int c = curC + dc[i];
            int r = curR + dr[i];
            if (c >=0 && r >=0 && c < n && r < n){
                if (visited[r][c] > sum+ map[r][c]){
                    visited[r][c] = sum + map[r][c];
                    dfs(map,visited,c,r,sum+map[r][c]);
                }
            }
        }
    }
}