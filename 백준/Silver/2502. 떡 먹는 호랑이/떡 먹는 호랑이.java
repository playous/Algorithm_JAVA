import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp1 = new int[d + 1];
        int[] dp2 = new int[d + 1];

        dp1[3] = 1;
        dp2[2] = 1;
        dp2[3] = 1;

        for (int i = 4; i <= d; i++) {
            dp1[i] = dp1[i - 1] + dp1[i - 2];
            dp2[i] = dp2[i - 1] + dp2[i - 2];
        }

        int day1 = 1;
        int day2 = 0;
        while (true) {
            int num = k - (dp1[d] * day1);
            if (num % dp2[d] == 0) {
                day2 = num / dp2[d];
                break;
            }
            day1++;
        }

        bw.write(day1 + "\n" + day2);
        bw.flush();
    }
}

