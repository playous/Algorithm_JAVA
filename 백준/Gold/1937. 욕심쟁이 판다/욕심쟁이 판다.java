import java.util.*;
import java.io.*;

class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int n;
    static int answer = 0;
    static int[][] map;
    static int[][] dp;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, dfs(i, j));
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    static int dfs(int r, int c) {
        if (dp[r][c] != 0) return dp[r][c];
        dp[r][c] = 1;

        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];
            if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < n) {
                if (map[r][c] < map[nextR][nextC]) {
                    dp[r][c] = Math.max(dp[r][c], dfs(nextR, nextC) + 1);
                }
            }
        }
        return dp[r][c];
    }
}