import java.util.*;
import java.io.*;

class Solution{
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    static int sr = 0;
    static int sc = 0;
    static int er = 0;
    static int ec = 0;
    
    static boolean[][] visited;
    static boolean[][] map;
    static boolean canGo;
    
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		
        for (int t = 1; t <= 10; t++){
            map = new boolean[16][16];
            visited = new boolean[16][16];
            canGo = false;
            
            int test = Integer.parseInt(br.readLine());
            for (int i = 0; i < 16 ; i ++){
                String s = br.readLine();
                for (int j = 0 ; j < 16 ; j ++){
                    char ch = s.charAt(j);
                    if (ch == '2'){
                        sr = i;
                        sc = j;
                    }
                    if (ch == '3'){
                        er = i;
                        ec = j;
                    }
                    map[i][j] = ch == '1' ? false : true;
                }
            }
            visited[sr][sc] = true;
            dfs(sr, sc);
            sb.append("#").append(t).append(" ").append(canGo ? 1 : 0).append("\n");
        }
        System.out.print(sb.toString());
    }
    public static void dfs(int r, int c){
        if (r == er && c == ec){
            canGo = true;
            return;
        }
        for (int i = 0 ; i < 4 ; i ++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < 16 && nc >= 0 && nc < 16){
                if (!visited[nr][nc] && map[nr][nc]){
                    visited[nr][nc] = true;
                    dfs(nr,nc);
                }
            }
        }
    }
}
