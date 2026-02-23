import java.io.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] dp = new long[91];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= 90 ; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int n = Integer.parseInt(br.readLine());
        System.out.println(dp[n]);

    }

}