import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, m, count;
    static int[] dc = {-1, 1, 0, 0};
    static int[] dr = {0, 0, -1, 1};

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int wCount = 0;
        int bCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'W' && !visited[i][j]) {
                    count = 0;
                    dfs(map, i, j, 'W');
                    wCount += (count * count);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'B' && !visited[i][j]) {
                    count = 0;
                    dfs(map, i, j, 'B');
                    bCount += (count * count);
                }
            }
        }


        bw.write(wCount+ " " + bCount + "\n");
        bw.flush();
    }

    static void dfs(char[][] map, int col, int row, char ch) {
        visited[col][row] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            int c = col + dc[i];
            int r = row + dr[i];

            if (c >= 0 && r >= 0 && c < n && r < m && !visited[c][r]) {
                if (map[c][r] == ch) {
                    dfs(map, c, r, ch);
                }
            }
        }
    }
}