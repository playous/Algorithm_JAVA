import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        long[] sum = new long[n + 1];
        HashMap<Long, Integer> map = new HashMap<>();
        sum[0] = 0;

        long answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
            long target = sum[i] - k;
            map.put(sum[i - 1], map.getOrDefault(sum[i - 1], 0) + 1);
            if (map.containsKey(target)) {
                answer += map.get(target);
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
