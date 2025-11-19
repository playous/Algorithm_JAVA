import java.io.*;
import java.util.*;

public class Solution {
    static class Node {
        int score;
        int cal;
        Node (int score, int cal) {
            this.score = score;
            this.cal = cal;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int T = 1; T <= t; T++) {
            int[] arr = new int[200];
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int s = (Integer.parseInt(st.nextToken()) - 1) / 2;
                int e = (Integer.parseInt(st.nextToken()) - 1) / 2;
                int min = Math.min(s, e);
                int max = Math.max(s, e);
                for (int j = min ; j <= max; j++) {
                    arr[j]++;
                }
            }

            int answer = 1;

            for (int i = 0 ; i < 200 ; i ++){
                answer = Math.max(answer, arr[i]);
            }

            sb.append("#").append(T).append(" ").append(answer).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}