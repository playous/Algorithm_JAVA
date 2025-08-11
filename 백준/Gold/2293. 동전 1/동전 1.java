import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a <= k) {
                set.add(a);
            }
        }

        int[] dp = new int[k + 1];
        dp[0] = 1;

        for (int num : set) {
            for (int i = num; i <= k; i++) {
                dp[i] += dp[i - num];
            }
        }
        bw.write(String.valueOf(dp[k]));
        bw.flush();
    }
}

