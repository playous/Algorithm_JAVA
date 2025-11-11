import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] w = new int[n + 1];
        int[] h = new int[n + 1];
        int[][] dp = new int[n + 1][100];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n ; i ++){
            int w1 = w[i];
            for (int j = 1; j < 100; j++) {
                if (w1 > j){
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], h[i] + dp[i-1][j- w1]);
                }
            }
        }

        bw.write(String.valueOf(dp[n][99]));
        bw.flush();
    }
}