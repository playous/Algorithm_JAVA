import java.io.*;
import java.util.*;

class Main
{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[]dp = new int[1000001];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;
        dp[5] = 8;

        for (int i = 6; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            if (dp[i] > 10000000) dp[i] %= 15746;
        }

        bw.write(String.valueOf(dp[n] % 15746));
        bw.flush();

    }
}