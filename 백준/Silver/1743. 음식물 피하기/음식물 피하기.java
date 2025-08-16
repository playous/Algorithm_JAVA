import java.io.*;
import java.util.*;

public class Main {
    static int[] dc = {-1, 1, 0, 0};
    static int[] dr = {0, 0, -1, 1};
    static int n, m, k;
    static boolean[][] visied;
    static int[][] map;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visied = new boolean[n + 1][m + 1];
        map = new int[n + 1][m + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 1 && !visied[i][j]) {
                    count = 0;
                    dfs(i, j);
                    answer = Math.max(answer, count);
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
    static void dfs(int x, int y) {
        visied[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int curC = x + dc[i];
            int curR = y + dr[i];

            if (curC >= 0 && curR >= 0 && curC <= n && curR <= m && map[curC][curR] == 1) {
                if (!visied[curC][curR]) {
                    dfs(curC, curR);
                }
            }
        }
    }
}