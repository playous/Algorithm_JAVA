
import java.util.*;
import java.io.*;

public class Main {
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        dp = new int[31][31];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            check(left, right);
            bw.write(String.valueOf(dp[left][right]) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static void check(int l, int r) {
        for (int i = 1; i <= l; i++) {
            for (int j = 1; j <= r; j++) {
                if(i == 1) dp[1][j] = j;
                else{
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j-1];
                }
            }
        }
    }

}