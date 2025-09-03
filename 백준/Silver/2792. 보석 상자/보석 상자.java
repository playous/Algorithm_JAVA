import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        int maxColor = 0;

        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            maxColor = Math.max(maxColor, arr[i]);
        }

        int min = 1;
        int max = maxColor;

        int answer = max;
        while (min <= max) {
            int mid = (max + min) / 2;
            int num = calc(mid);
            if (n >= num) {
                answer = Math.min(answer, num);
                max = mid - 1;
            }
            else {
                min = mid + 1;
            }
        }
        bw.write(String.valueOf(min));
        bw.flush();
    }

    static int calc(int mid) {
        int sum = 0;
        for (int num : arr) {
            sum += (num / mid);
            if (num % mid != 0) sum += 1;
        }
        return sum;
    }
}
