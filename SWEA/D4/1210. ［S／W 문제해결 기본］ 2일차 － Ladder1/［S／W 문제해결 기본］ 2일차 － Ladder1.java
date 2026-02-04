import java.io.*;
import java.util.*;

public class Solution {
    
    static int[] dr = {0, 0, 1};
    static int[] dc = {-1, 1, 0};
    
    static boolean[][] visited;
    static int[][] map;
    static int endCol;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int t = 0; t < 10; t++) {
            int n = Integer.parseInt(br.readLine());
            int answer = 0;
            map = new int[100][100];
            
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (i == 99 && map[i][j] == 2) endCol = j;
                }
            }
            
            for (int j = 0; j < 100 ; j ++){
                if(map[0][j] == 1){
                    visited = new boolean[100][100];
                    if (dfs(0, j) == endCol) {
                        answer = j;
                        break;
                    }
                }
            }
            sb.append("#").append(n).append(" ").append(answer).append("\n");
        }
        System.out.print(sb.toString());
    }
    
    public static int dfs(int r, int c){
        visited[r][c] = true;
        if(r == 99){
            return c;
        }
        
        if(c - 1 >= 0 && map[r][c-1] == 1 && !visited[r][c-1] ) return dfs(r, c-1);
		else if(c + 1 < 100 && map[r][c+1] == 1 && !visited[r][c+1]) return dfs(r, c+1);
		else return dfs(r+1, c); 
    }
}