import java.util.*;
import java.io.*;

class Main {

    static int n, m ;
    static boolean[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new boolean[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) == '1';
            }
        }

        for (int i = 0; i < n; i++) {
            if (map[i][0]) dp[i][0] = 1;
        }
        for (int j = 0; j < m; j++) {
            if (map[0][j]) dp[0][j] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (map[i][j])
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
            }
        }

        int len = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                len = Math.max(len, dp[i][j]);
            }
        }
        bw.write(String.valueOf(len * len));

        bw.flush();
    }
}

