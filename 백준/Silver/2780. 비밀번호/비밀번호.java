import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        long[][] dp = new long[10][1001];
        int[][] count = {
                {7},
                {2, 4},
                {1, 3, 5},
                {2, 6},
                {1, 5, 7},
                {2, 4, 6, 8},
                {3, 5, 9},
                {0, 4, 8},
                {5, 7, 9},
                {6, 8}
        };
        for (int i = 0; i <= 9; i++) {
            dp[i][1] = 1;
        }
        for (int i = 2; i <= 1000; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int num : count[j]) {
                    dp[j][i] = (dp[j][i] + dp[num][i - 1]) % 1234567;
                }
            }
        }

        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            long sum = 0;
            for (int i = 0; i <= 9; i++) {
                sum = (sum + dp[i][n]) % 1234567;
            }
            bw.write(sum + "\n");
            t--;
        }
        bw.flush();
    }
}
