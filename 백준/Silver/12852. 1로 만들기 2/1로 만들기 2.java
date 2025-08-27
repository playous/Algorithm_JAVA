import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            if (i % 3 == 0){
                dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
            }
            if (i % 2 == 0){
                dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
            }
            dp[i] = Math.min(dp[i], dp[i-1] + 1);
        }

        int count = dp[n];
        bw.write(count + "\n");
        bw.write(n + " ");

        int idx = n;

        for (int i = count; i >= 1; i--) {
            if (idx % 3 == 0 && dp[idx/3] == i - 1){
                idx /= 3;
                bw.write(idx + " ");
            } else if (idx % 2 == 0 && dp[idx/2] == i - 1) {
                idx /= 2;
                bw.write(idx + " ");
            }
            else {
                idx -= 1;
                bw.write(idx + " ");
            }
        }
        bw.flush();
    }
}
