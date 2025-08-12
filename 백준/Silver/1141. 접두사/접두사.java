import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            String s = arr[i];
            boolean check = true;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].startsWith(s)) {
                    check = false;
                    break;
                }
            }
            if (check) {
                answer ++;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}