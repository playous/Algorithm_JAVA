import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                answer = Math.min(answer, calc(i, j));
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }

    static int calc(int i, int j){
        int goal = arr[i] + arr[j];
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = n - 1;
        while (left < right){
            if(left == i || left == j) {
                left++;
                continue;
            }
            if(right == i || right == j) {
                right--;
                continue;
            }
            int sum = arr[left] + arr[right];
            int min1 = Math.abs(goal - sum);
            min = Math.min(min1, min);

            if (min1 == 0) break;

            if (sum > goal) right--;
            else left++;
        }
        return min;
    }
}