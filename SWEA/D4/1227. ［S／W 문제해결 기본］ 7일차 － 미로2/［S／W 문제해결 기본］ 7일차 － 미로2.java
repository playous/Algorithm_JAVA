import java.io.*;
import java.util.*;

public class Solution {

    static int startR, startC, endR, endC;
    static boolean[][] visited;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1 , 1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        for (int t = 1; t <= 10 ; t++){
            int n = Integer.parseInt(br.readLine());

            map = new int[100][100];
            visited = new boolean[100][100];

            for (int i = 0 ; i < 100 ; i ++){
                String line = br.readLine();
                for (int j = 0; j < 100 ; j ++){
                    map[i][j] = line.charAt(j) - '0';
                    if(map[i][j] == 2){
                        startR = i;
                        startC = j;
                    }
                    if (map[i][j] == 3){
                        endR = i;
                        endC = j;
                    }
                }
            }

            boolean canGo = dfs(startR, startC);
            int answer = canGo ? 1 : 0;

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static boolean dfs(int r, int c){
        visited[r][c] = true;
        if (r == endR && c == endC) return true;

        for (int i = 0 ; i < 4 ; i ++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nc >=0 && nr < 100 && nc < 100){
                if (!visited[nr][nc] && map[nr][nc] != 1){
                    if(dfs(nr,nc)) return true;
                }
            }
        }
        return false;
    }

}