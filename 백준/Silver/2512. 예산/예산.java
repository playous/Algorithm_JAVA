import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    static int maxSum = 0;
    static int answer = 0;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        int m = Integer.parseInt(br.readLine());

        calc(0, max, m, arr);
        System.out.println(answer);
    }

    static void calc(int min, int max, int m, int[] arr) {
        if (min > max) return;

        int mid = (min + max)/2;
        int sum = 0;
        int maxCost = 0;
        for (int i : arr) {
            if (i < mid) {
                sum += i;
                maxCost = Math.max(maxCost, i);
            } else {
                sum += mid;
                maxCost = Math.max(maxCost, mid);
            }
        }
        if(sum <= m) {
            maxSum = Math.max(maxSum, sum);
            if (maxSum == sum) answer = maxCost;
            calc(mid + 1, max, m, arr);
        } else calc(min, mid - 1, m, arr);

    }
}