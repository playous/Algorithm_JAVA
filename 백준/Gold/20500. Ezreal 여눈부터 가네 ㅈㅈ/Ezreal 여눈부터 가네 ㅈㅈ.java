import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1516];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = ((dp[i - 1] % 1000000007) + ((dp[i - 2] * 2) % 1000000007)) % 1000000007;
        }

        bw.write(String.valueOf(dp[n]));
        bw.flush();
    }
}
