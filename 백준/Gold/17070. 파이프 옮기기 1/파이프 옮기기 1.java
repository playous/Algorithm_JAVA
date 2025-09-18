import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        boolean[][] wall = new boolean[n + 1][n + 1];

        /*
        z축
        0 -> 가로 상태
        1 -> 세로 상태
        2 -> 대각선 상태
         */
        int[][][] dp = new int[n + 1][n + 1][3];

        for (int i = 1; i <= n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                if (line[j-1].charAt(0) == '1') wall[i][j] = true;
            }
        }

        dp[1][2][0] = 1; // 초기 위치

        for (int i = 1; i <= n; i++) {
            for (int j = 3; j <= n; j++) {  // 1, 2열은 갈 수 있는 방법 x
                if (wall[i][j]) continue;
                dp[i][j][0] += dp[i][j - 1][2] + dp[i][j - 1][0];
                dp[i][j][1] += dp[i - 1][j][2] + dp[i - 1][j][1];
                if (!wall[i - 1][j] && !wall[i][j - 1]) {
                    int sum = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
                    dp[i][j][2] += sum;
                }
            }
        }

        int answer = dp[n][n][0] + dp[n][n][1] + dp[n][n][2];

        bw.write(String.valueOf(String.valueOf(answer)));
        bw.flush();
    }
}

