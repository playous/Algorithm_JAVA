import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int n, m;
    static boolean[][] visited ;
    static class Node {
        int r;
        int c;
        int level;
        Node(int r, int c, int level) {
            this.r = r;
            this.c = c;
            this.level = level;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'L') {
                    visited = new boolean[n][m];
                    answer = Math.max(bfs(i, j), answer);
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    static int bfs(int r, int c) {
        int max = 0;
        visited[r][c] = true;
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(r, c, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int cr = cur.r;
            int cc = cur.c;
            int level = cur.level;
            max = Math.max(max, level);
            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if (nr >= 0 && nc >= 0 && nr < n && nc < m){
                    if (map[nr][nc] == 'L' && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.add(new Node(nr, nc, level + 1));
                    }
                }
            }
        }
        return max;
    }
}