import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int[][] map;
    static boolean[][] visited;

    static boolean flag;
    static int startR, startC;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1 ; t <= 10 ; t ++){
            String d = br.readLine();

            flag = false;
            map = new int[16][16];
            visited = new boolean[16][16];

            for (int i = 0 ; i < 16 ; i ++){
                String s = br.readLine();
                for (int j = 0 ; j < 16 ; j ++){
                    map[i][j] = s.charAt(j) - '0';

                    if (map[i][j] == 2){
                        startR = i;
                        startC = j;
                    }
                }
            }

            dfs(startR, startC);

            sb.append("#").append(t).append(" ").append(flag ? 1 : 0).append("\n");
        }

        System.out.print(sb.toString());
    }

    public static void dfs(int r, int c){
        visited[r][c] = true;

        if (map[r][c] == 3){
            flag = true;
            return;
        }

        for (int i = 0 ; i < 4 ; i ++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nc >= 0 && nr < 16 && nc < 16){
                if (map[nr][nc] != 1 && !visited[nr][nc]){
                    dfs(nr, nc);
                }
            }
        }
    }
}