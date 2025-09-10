import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n + 1];
        int zeroCount = 0;
        for (int i = 1; i <= n; i++) {
            int k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                zeroCount++;
            }
            arr[i] = k;
        }
        Arrays.sort(arr);

        int answer = 0;

        while (arr[n] != 0) {
            boolean flag = true;
            for (int i = zeroCount; i <= n; i++) {
                int cur = arr[i];
                if (cur != 0){
                    if (cur % 2 != 0){
                        arr[i] -= 1;
                        answer++;
                        flag = false;
                    }
                }
            }
            if (flag){
                for (int i = zeroCount; i <= n; i++) {
                    int cur = arr[i];
                    if (cur != 0){
                       arr[i] /= 2;
                    }
                }
                answer ++;
            }
            Arrays.sort(arr);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}