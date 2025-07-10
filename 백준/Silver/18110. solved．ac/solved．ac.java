import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int k = (int) Math.round((double) n * 0.15);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int answer = 0;
        for (int i = k; i < n - k; i++) {
            answer += arr[i];
        }
        answer = (int) Math.round((double)answer / (n - (2 * k)));
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}