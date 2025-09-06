import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;

    static class Tomato {
        int row;
        int col;
        int level;
        public Tomato(int row, int col, int level) {
            this.row = row;
            this.col = col;
            this.level = level;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        Queue<Tomato> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.add(new Tomato(i, j, 0));
                }
            }
        }

        int days = 0;
        while(!q.isEmpty()) {
            Tomato tomato = q.poll();
            int row = tomato.row;
            int col = tomato.col;
            int level = tomato.level;
            days = Math.max(days, level);
            for (int i = 0; i < 4; i++) {
                int curRow = row + dr[i];
                int curCol = col + dc[i];
                if (curRow >= 0 && curRow < n && curCol >= 0 && curCol < m) {
                    if (map[curRow][curCol] == 0) {
                        map[curRow][curCol] = 1;
                        q.add(new Tomato(curRow, curCol, level + 1));
                    }
                }
            }
        }

        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    flag = false;
                }
            }
        }
        if (flag) {
            bw.write(String.valueOf(days));
        }
        else {
            bw.write("-1");
        }
        bw.flush();
    }
}
