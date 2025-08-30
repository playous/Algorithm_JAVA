import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] arr = br.readLine().toCharArray();

        if (arr[0] == '0') {
            bw.write("0");
            bw.flush();
            return;
        }

        int[] dp = new int[arr.length + 1];
        dp[0] = 1; 
        dp[1] = 1;  
        for (int i = 2; i <= arr.length; i++) {
            if (arr[i-1] != '0') {
                dp[i] += dp[i - 1];
            }

            if (arr[i-2] == '1') {
                dp[i] += dp[i - 2];
            }
            else if (arr[i-2] == '2' && arr[i-1] - '0' <= 6) {
                dp[i] += dp[i - 2];
            }

            dp[i] %= 1000000;  
        }
        bw.write(String.valueOf(dp[arr.length]));
        bw.flush();
    }
}