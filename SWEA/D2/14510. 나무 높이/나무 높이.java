import java.util.*;
import java.io.*;

class Solution {
    static int n;
    static int[] arr;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            st = new StringTokenizer(br.readLine());

            int max = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i]);
            }

            int remain1 = 0;
            int remain2 = 0;

            for (int i = 0; i < n; i++) {
                int diff = max - arr[i];
                if (diff == 0) continue;

                remain2 += (diff / 2);
                remain1 += (diff % 2);
            }

            long answer = 0;

            if (remain2 > remain1) {
                while (remain2 > remain1 + 1) {
                    remain2--;
                    remain1 += 2;
                }
            }

            if (remain1 > remain2) {
                answer = remain1 * 2 - 1;
            } else if (remain2 > remain1) {
                answer = remain2 * 2;
            } else {
                answer = remain1 * 2;
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.print(sb.toString());
    }
}