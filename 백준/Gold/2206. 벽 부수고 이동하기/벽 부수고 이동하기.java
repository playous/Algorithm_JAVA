import java.io.*;
import java.util.*;

public class Main {
    static int[] dc = {-1, 1, 0, 0};
    static int[] dr = {0, 0, -1, 1};
    static char[][] map;
    static boolean[][][] visited; 
    static int n, m;

    static class Node {
        int x, y, count;
        boolean wallBroken;

        Node(int x, int y, int count, boolean wallBroken) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.wallBroken = wallBroken;
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
        visited = new boolean[n][m][2]; 

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = input[j];
            }
        }

        int result = bfs();
        bw.write(String.valueOf(result));
        bw.flush();
    }

    static int bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0, 1, false));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int x = current.x;
            int y = current.y;
            int count = current.count;
            boolean wallBroken = current.wallBroken;

            if (x == n - 1 && y == m - 1) {
                return count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dc[i];
                int ny = y + dr[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (map[nx][ny] == '0') {
                        int wallState = wallBroken ? 1 : 0;
                        if (!visited[nx][ny][wallState]) {
                            visited[nx][ny][wallState] = true;
                            queue.offer(new Node(nx, ny, count + 1, wallBroken));
                        }
                    }
                    else if (map[nx][ny] == '1' && !wallBroken) {
                        if (!visited[nx][ny][1]) {
                            visited[nx][ny][1] = true;
                            queue.offer(new Node(nx, ny, count + 1, true));
                        }
                    }
                }
            }
        }

        return -1; 
    }
}