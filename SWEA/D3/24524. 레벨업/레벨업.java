import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t > 0){
            int n = Integer.parseInt(br.readLine());
            int answer = Integer.MAX_VALUE;

            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < n - 1; i++){
                int len = 0;
                int prev = arr[0];
                for (int j = 1; j < n; j++) {
                    if (i == j) {
                        prev = arr[j - 1];
                        continue;
                    }
                    len += Math.abs(arr[j] - prev);
                    prev = arr[j];
                }
                answer = Math.min(answer, len);
            }
            bw.write(answer + "\n");
            t--;
        }

        bw.flush();
    }
}