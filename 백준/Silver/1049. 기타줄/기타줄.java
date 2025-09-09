import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a < min1) {
                min1 = a;
            }
            if (b < min2) {
                min2 = b;
            }
        }
        int answer = 0;
        int cost = Math.min(min1, min2 * 6);
        if (n > 6) {
            int k = n / 6;
            answer += cost * k;
            n %= 6;
        }
        cost = Math.min(min1, min2 * n);
        answer += cost;

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}