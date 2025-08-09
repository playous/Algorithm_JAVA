import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Work{
        int days;
        int cost;
        public Work(int days, int cost) {
            this.days = days;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Work[] works = new Work[n+1];
        List<Integer>[] before = new List[n + 2];
        for (int i = 1; i <= n + 1; i++) {
            before[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            works[i] = new Work(day, cost);
            if (day + i <= n + 1) {
                before[day+i].add(i);
            }
        }
        int[] dp = new int [n+2];
        dp[0] = 0;

        for (int i = 1; i <= n + 1; i++) {
            if(before[i].size() == 0){
                dp[i] = dp[i - 1];
            }
            else{
                int c = 0;
                for (int a : before[i]) {
                    c = Math.max(c, works[a].cost + dp[i - works[a].days]);
                }
                dp[i] = Math.max(dp[i - 1], c);
            }
        }
        bw.write(String.valueOf(dp[n + 1]));
        bw.flush();
    }
}