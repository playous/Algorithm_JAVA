import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        boolean[][] visted = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 1;
        for (int c = 1; c <= 100; c++) {
            int count = 0;
            visted = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(!visted[i][j] && map[i][j] > c) {
                        dfs(map, visted, i, j, c);
                        count++;
                    }
                }
            }
            answer = Math.max(answer, count);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    static void dfs(int[][] map, boolean[][] visited, int x, int y, int c) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && map[nx][ny] > c && !visited[nx][ny]) {
                dfs(map, visited, nx, ny, c);
            }
        }
    }
}