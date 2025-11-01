import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int[] horse_r = {-2, -2, -1, 1, 2, 2, -1, 1};
    static int[] horse_c = {1, -1, 2, 2, 1, -1, -2, -2};

    static class Node {
        int r;
        int c;
        int k;
        int count;
        public Node(int r, int c, int k, int count) {
            this.r = r;
            this.c = c;
            this.k = k;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[h][w];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                if (st.nextToken().equals("0")) map[i][j] = true;
            }
        }

        boolean[][][] visited = new boolean[k + 1][h][w];
        PriorityQueue<Node> q = new PriorityQueue<>((a,b) -> a.count - b.count);
        q.add(new Node(0, 0, k, 0));
        visited[k][0][0] = true;

        int answer = -1;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int r = cur.r;
            int c = cur.c;
            int horse = cur.k;
            int count = cur.count;

            if (r == h - 1 && c == w - 1) {
                answer = count;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nc >= 0 && nr < h && nc < w){
                    if (map[nr][nc] && !visited[horse][nr][nc]) {
                        q.add(new Node(nr, nc, horse, count + 1));
                        visited[horse][nr][nc] = true;
                    }
                }
            }
            if (horse > 0) {
                for (int i = 0; i < 8; i++) {
                    int nr = r + horse_r[i];
                    int nc = c + horse_c[i];
                    if (nr >= 0 && nc >= 0 && nr < h && nc < w) {
                        if (map[nr][nc] && !visited[horse - 1][nr][nc]) {
                            q.add(new Node(nr, nc, horse - 1, count + 1));
                            visited[horse - 1][nr][nc] = true;
                        }
                    }
                }
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
