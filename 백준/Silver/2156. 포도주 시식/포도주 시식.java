import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = arr[1];
        int answer = 0;

        if (n >= 2){
            dp[2] = arr[1] + arr[2];
        }
        if (n >= 3){
            dp[3] = Math.max(Math.max(dp[2], arr[2] + arr[3]),arr[1] + arr[3]);
        }
        if (n >= 4) {
            for (int i = 4; i <= n; i++) {
                dp[i] = Math.max(Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]), dp[i - 1]);
            }
        }

        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, dp[i]);
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
    }

}