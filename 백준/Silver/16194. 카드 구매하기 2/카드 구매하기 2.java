import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n + 1];
        int[] dp = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            int cnt = 1;
            int c = cards[i];
            for (int j = i; j <= n; j += i) {
                dp[j] = Math.min(dp[j],cnt * c);
                cnt++;
            }
        }

        if (n >= 3) {
            for (int i = 3; i <= n; i++) {
                for (int j = 1; j <= i / 2; j++) {
                    dp[i] = Math.min(cards[j] + dp[i - j], dp[i]);
                }
            }
        }
        bw.write(String.valueOf(dp[n]));
        bw.flush();
    }


}