import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int left = 0;

            for (int j = 1; j <= n; j++) {
                if (left == arr[i] && answer[j] == 0) {
                    answer[j] = i;
                    break;
                }
                if (answer[j] == 0) {
                    left++;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            bw.write(answer[i] + " ");
        }
        bw.flush();
    }
}