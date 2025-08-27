import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1];
            if (arr[i] > arr[i + 1]) {
                dp[i]++;
            }
        }

        int q = Integer.parseInt(br.readLine());
        for (int i = 1; i <= q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            bw.write(dp[y - 1] - dp[x - 1] + "\n");
        }

        bw.flush();
    }
}