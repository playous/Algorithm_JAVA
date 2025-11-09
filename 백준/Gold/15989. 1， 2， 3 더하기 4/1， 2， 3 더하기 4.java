import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        int[] dp = new int[10001];

        for (int i = 0; i <= 10000; i++) {
            dp[i] = 1;
        }
        for (int i = 2; i <= 10000; i ++){
            dp[i] += dp[i - 2];
        }
        for (int i = 3; i <= 10000; i ++){
            dp[i] += dp[i - 3];
        }

        while(t > 0){
            t--;
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n] + "\n");
        }

        bw.write(sb.toString());
        bw.flush();


    }

}

