import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());

        dp = new long[30];
        long sum = 0;
        int len = 0;
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            sum += (long) Math.pow(2, i);
            dp[i] = sum;
            if (sum >= k) {
                len = i;
                break;
            }
        }

        calc(len, k - dp[len-1]);
        bw.write(sb.toString());
        bw.flush();
    }

    static void calc(int digit, long k) {
        if (digit == 0) return;

        long half = (long) Math.pow(2, digit - 1);

        if (k <= half) {
            sb.append("4");
            calc(digit - 1, k);
        } else {
            sb.append("7");
            calc(digit - 1, k - half);
        }
    }

}
