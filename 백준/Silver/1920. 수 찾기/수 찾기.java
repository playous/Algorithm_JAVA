import java.io.*;
import java.util.*;

public class Main {

    static long[] arr;
    static long a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arr = new long[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            a = Long.parseLong(st.nextToken());
            bw.write(String.valueOf(find(0,n-1)));
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static int find(int min, int max) {
        int sum = (min + max) / 2;

        if (arr[sum] == a) return 1;

        if (min < max) {
            if (arr[sum] < a) {
                return find(sum + 1, max);
            }
            if (arr[sum] > a) {
                return find(min, sum - 1);
            }
        }
        return 0;
    }

}
