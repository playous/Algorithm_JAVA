import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        long[][] dp = new long[100001][4];

        dp[1][1] = 1; // 1
        dp[2][2] = 1; // 2
        dp[3][1] = 1; // 2+1
        dp[3][2] = 1; // 1+2
        dp[3][3] = 1; // 3

        for (int i = 4 ; i <= 100000 ; i++) {
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % 1000000009;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % 1000000009;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % 1000000009;
        }
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            t--;
            long sum = 0;
            for (int i = 1; i <= 3; i++) {
                sum += dp[n][i];
            }
            bw.write(String.valueOf(sum % 1000000009) + "\n");
        }
        bw.flush();
    }
}