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
        st = new StringTokenizer(br.readLine());

        int max = 0;
        int min = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max += arr[i];
            min = Math.max(min, arr[i]);
        }

        while (max >= min) {
            int cur = (max + min) / 2;
            int count = check(cur);
            if (count <= m) {
                max = cur -1;
            } else {
                min = cur + 1;
            }
        }
        bw.write(String.valueOf(min));
        bw.flush();
    }

    static int check(int answer) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (sum + arr[i] > answer) {
                count++;
                sum = 0;
            }
            sum += arr[i];
        }
        if (sum != 0) count++;
        return count;
    }
}

