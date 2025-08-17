import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] volume = new int[n + 1];
        int[][] dp = new int[n + 1][m + 1];
        dp[0][s] = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            volume[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            int cur = volume[i];
            for (int j = 0; j <= m; j++) {
                if (dp[i-1][j] == 1){
                    if(j + cur <= m) dp[i][j+cur] = 1;
                    if(j - cur >= 0) dp[i][j-cur] = 1;
                }
            }
        }

        int answer = -1;
        for (int i = 0; i <= m; i++) {
            if (dp[n][i] == 1) answer = i;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}