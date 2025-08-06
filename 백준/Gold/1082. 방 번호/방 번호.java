import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        String[][] dp = new String[m+1][m+1]; // 글자수, 총 비용

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = "";
            }
        }

        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if(cost[i] > m) cnt++;
        }
        if(cnt == n-1) {
            bw.write("0");
            bw.flush();
            return;
        }

        for (int i = 1; i < n; i++) {
            if (cost[i] > m) {
                continue;
            }
            dp[1][cost[i]] = String.valueOf(i);
        }


        int maxi = m;
        for (int i = 2; i <= m; i++) {
            boolean flag = false;
            int idx = 0;
            for (int c1 : cost) {
                if (idx == 0 && i == 1 || c1 > m){
                    idx++;
                    continue;
                }
                for (int j = 1; j <= m - c1; j++) {
                    if (dp[i-1][j] != "") {
                        dp[i][j+c1] = dp[i][j+c1].compareTo(dp[i-1][j] + String.valueOf(idx)) > 0 ? dp[i][j+c1] : dp[i-1][j] + String.valueOf(idx);
                        flag = true;
                    }
                }
                idx++;
            }
            if (!flag){
                maxi = i - 1;
                break;
            }
        }

        String answer = "";
        for (int i = 1; i <= m; i++) {
            if(dp[maxi][i].compareTo(answer) > 0){
                answer = dp[maxi][i];
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}