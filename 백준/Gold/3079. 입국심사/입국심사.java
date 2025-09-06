import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        Long max = 0L;
        Long min = 1L;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        max *= m;

        while (max >= min) {
            Long mid = (max + min)/ 2;
            boolean check = can(mid);
            if (check) {
                max = mid - 1;
            }
            else {
                min = mid + 1;
            }
        }

        bw.write(min + "\n");

        bw.flush();
    }

    static boolean can(Long time) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += time/arr[i];
            if (sum >= m) {
                break;
            }
        }
        return sum >= m;
    }
}
