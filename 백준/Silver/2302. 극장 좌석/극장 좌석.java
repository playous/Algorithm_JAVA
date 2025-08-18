import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int vip = Integer.parseInt(br.readLine());
            arr[vip] = 0;
        }

        int answer = 1;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                answer *= dp[count];
                count = 0;
            }
            else{
                count++;
            }
        }
        answer *= dp[count];

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}

/*
1 -> 1, [1]
2 -> 1 + 1, [1,2] [2,1]
3 -> 2 + 1,[1,2,3] [1,3,2] [2,1,3]
4 -> 3 + 2, [1,2,3,4] [1,2,4,3] [1,3,2,4] [2,1,3,4] [2,1,4,3]
5 -> 5 + 3,[1,2,3,4,5] [1,2,4,3,5] [1,3,2,4,5] [2,1,3,4,5] [2,1,4,3,5] [1,2,3,5,4] [1,3,2,5,4] [2,1,3,5,4]
6 -> 8 + 5
 */