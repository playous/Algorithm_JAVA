import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] map, dp;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        answer = dfs(0, 0);

        bw.write(String.valueOf(answer));
        bw.flush();

    }
    static int dfs(int r, int c){
        if (r == n - 1 && c == m - 1) {
            return 1;
        }
        if (dp[r][c] != -1){
            return dp[r][c];
        }
        
        dp[r][c] = 0;

        for (int k = 0; k < 4; k++) {
            int nextR = r + dr[k];
            int nextC = c + dc[k];
            if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < m) {
                if (map[nextR][nextC] < map[r][c]) {
                    dp[r][c] += dfs(nextR, nextC);
                }
            }
        }
        return dp[r][c];
    }
}
