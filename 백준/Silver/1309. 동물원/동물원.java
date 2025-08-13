import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 3;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 2] * 3 + (dp[i - 1] - dp[i - 2]) * 2) % 9901;
        }


        bw.write(String.valueOf(dp[n]));
        bw.flush();
    }


}