import java.io.*;
import java.util.*;

public class Main {

    static int[] dc = {-1, 1, 0, 0};
    static int[] dr = {0, 0, -1, 1};

    static int[][] map1, map2;
    static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map1 = new int[r][c];
        map2 = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag = true;
        for (int i = 0; i < r && flag; i++) {
            for (int j = 0; j < c; j++) {
                if (map1[i][j] != map2[i][j]) {
                    dfs(i, j, map1[i][j], map2[i][j]);
                    map1[i][j] = map2[i][j];
                    flag = false;
                    break;
                }
            }
        }

        flag = true;

        for (int i = 0; i < r && flag; i++) {
            for (int j = 0; j < c; j++) {
                if (map1[i][j] != map2[i][j]) {
                    flag = false;
                    break;
                }
            }
        }

        bw.write(flag ? "YES" : "NO");
        bw.flush();

    }

    static void dfs(int cr, int cc, int cur, int goal) {
        for (int i = 0; i < 4; i++) {
            int nr = cr + dr[i];
            int nc = cc + dc[i];
            if (nr >= 0 && nr < r && nc >= 0 && nc < c) {
                if (map1[nr][nc] == cur) {
                    map1[nr][nc] = goal;
                    dfs(nr, nc, cur, goal);
                }
            }

        }
    }
}

