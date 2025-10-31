import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

        boolean[][] dp = new boolean[n][40001];
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        dp[0][list.get(0)] = true;
        int left = 0;
        int right = 0;

        for (int i = 1; i < n; i++) {
            int cur = list.get(i);
            dp[i][cur] = true;
            for (int j = 0; j <= 40000; j++) {
                if (dp[i-1][j]){
                    left = Math.abs(j - cur);
                    right = j + cur;
                    if (left > 0) dp[i][left] = true;
                    if (right <= 40000) dp[i][right] = true;
                    dp[i][j] = true;
                }
            }
        }

        int c = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < c; i++) {
            int check = Integer.parseInt(st.nextToken());
            if (dp[n-1][check]){
                sb.append("Y").append(" ");
            }
            else {
                sb.append("N").append(" ");
            }
        }

        bw.write(sb.toString());
        bw.flush();

    }

}
