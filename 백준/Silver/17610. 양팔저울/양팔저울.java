import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        HashSet<Integer> set = new HashSet<>();

        int count = 1;
        for (int i = 0; i < n; i++) {
            count *= 3;
        }

        for (int mask = 0; mask < count; mask++) {
            int left = 0;
            int right = 0;
            int cur = mask;

            for (int i = 0; i < n; i++) {
                int state = cur % 3;
                cur /= 3;

                if (state == 1) {          // 왼쪽 배치
                    left += arr[i];
                } else if (state == 2) {   // 오른쪽 배치
                    right += arr[i];
                }
            }

            int weight = Math.abs(left - right);
            if (weight > 0) {
                set.add(weight);
            }
        }

        int answer = 0;
        for (int i = 1; i <= sum; i++) {
            if (!set.contains(i)) {
                answer++;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}