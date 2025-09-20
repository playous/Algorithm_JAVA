import java.io.*;
import java.util.*;

public class Main {
    static class Problem{
        int time;
        int score;
        public Problem(int time, int score){
            this.time = time;
            this.score = score;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][t + 1];
        Problem[] p = new Problem[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            p[i] = new Problem(k, s);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= t; j++) {
                if (p[i].time <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-p[i].time] + p[i].score);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        bw.write(String.valueOf(dp[n][t]));
        bw.flush();
        bw.close();
    }
}