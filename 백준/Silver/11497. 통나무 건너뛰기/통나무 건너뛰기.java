import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int[] answerArr = new int[n];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int left = 0;
            int right = n - 1;
            for (int i = 0; i < n; i++) {
                if (i == 0 || i % 2 == 0) {
                    answerArr[left++] = arr[i];
                }
                else{
                    answerArr[right--] = arr[i];
                }
            }

            int max = answerArr[n - 1] - answerArr[0];
            for (int i = 0; i < n - 1; i++) {
                max = Math.max(max, Math.abs(answerArr[i + 1] - answerArr[i]));
            }
            bw.write(max + "\n");
            t--;
        }
        bw.flush();
    }
}
