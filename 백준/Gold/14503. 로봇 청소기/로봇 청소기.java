import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;
    static boolean[][] clean;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer = 0;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        clean = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            if (!clean[r][c]) {
                clean[r][c] = true;
                answer++;
            }

            boolean found = false;
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    if (map[nr][nc] == 0 && !clean[nr][nc]) {
                        r = nr;
                        c = nc;
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                int back = (d + 2) % 4; 
                int nr = r + dr[back];
                int nc = c + dc[back];

                if (map[nr][nc] == 1) {
                    break;
                }
                
                r = nr;
                c = nc;
            }
        }

        System.out.println(answer);
    }
}