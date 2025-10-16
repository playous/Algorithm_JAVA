import java.io.*;
import java.util.*;

class Main {
    static int n, l, r, x;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    static void backtrack(int idx, int sum, int min, int max) {
        if (idx == n) {
            if (min != Integer.MAX_VALUE && max != Integer.MIN_VALUE) {
                if (sum >= l && sum <= r && (max - min) >= x) {
                    answer++;
                }
            }
            return;
        }

        backtrack(idx + 1, sum + arr[idx], Math.min(min, arr[idx]), Math.max(max, arr[idx]));

        backtrack(idx + 1, sum, min, max);
    }
}