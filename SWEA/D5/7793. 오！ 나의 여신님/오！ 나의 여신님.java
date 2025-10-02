import java.util.*;
import java.io.*;

class Solution
{
	static char[][] map;
    static int[][] witch;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node{
        int r;
        int c;
        int time;

        public Node(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Queue<Node> q = new ArrayDeque<>();
            map = new char[n][m];
            witch = new int[n][m];
            for (int i = 0; i < n; i++) {
                Arrays.fill(witch[i], Integer.MAX_VALUE);
            }
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                map[i] = br.readLine().toCharArray();
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == '*') {
                        q.add(new Node(i, j, 0));
                        visited[i][j] = true;
                        break;
                    }
                }
            }
            while (!q.isEmpty()) {
                Node cur = q.poll();
                int r = cur.r;
                int c = cur.c;
                int t = cur.time;
                witch[r][c] = t;
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                        if (!visited[nr][nc] && map[nr][nc] == '.') {
                            q.add(new Node(nr, nc, t + 1));
                            visited[nr][nc] = true;
                        }
                    }
                }
            }

            q = new ArrayDeque<>();
            visited = new boolean[n][m];
            boolean flag = false;
            int answer = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 'S') {
                        q.add(new Node(i, j, 0));
                        visited[i][j] = true;
                        break;
                    }
                }
            }
            while (!q.isEmpty()) {
                Node cur = q.poll();
                int r = cur.r;
                int c = cur.c;
                int t = cur.time;
                if (map[r][c] == 'D') {
                    answer = t;
                    flag = true;
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                        if (!visited[nr][nc] && map[nr][nc] != 'X' && witch[nr][nc] > t + 1) {
                            q.add(new Node(nr, nc, t + 1));
                            visited[nr][nc] = true;
                        }
                    }
                }
            }
            sb.append("#").append(test_case).append(" ");
            if (flag) {
                sb.append(answer);
            }else{
                sb.append("GAME OVER");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}