import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());

            int[] dp = new int[m + 1];
            dp[0] = 1;

            for (int coin : arr) {
                for (int i = coin; i <= m; i++) {
                    dp[i] += dp[i - coin];
                }
            }

            bw.write(String.valueOf(dp[m]) + "\n");

            t--;
        }
        bw.flush();
    }
}
