import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][m];
            boolean[][] visited = new boolean[n][m];
            int count = 0;

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a][b] = 1;
            }
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {
                    if(map[a][b] == 1 && !visited[a][b]) {
                        dfs(map, visited, a, b);
                        count++;
                    }
                }
            }
            sb.append(String.valueOf(count) + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static void dfs(int[][] map, boolean[][] visited, int a, int b) {
        visited[a][b] = true;
        for (int i = 0; i < 4; i++) {
            int x = a + dx[i];
            int y = b + dy[i];
            if(x >= 0 && x < map.length && y >= 0 && y < map[0].length && !visited[x][y] && map[x][y] == 1) {
                dfs(map, visited, x, y);
            }
        }
    }
}