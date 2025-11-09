import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] dp = new int[15][15];

        for (int i = 1; i < 15; i ++){
            dp[0][i] = i;
        }
        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j - 1];
            }
        }

        int t = Integer.parseInt(br.readLine());
        while(t > 0){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(dp[k][n] + "\n"));
            t--;
        }

        bw.flush();
    }
}