import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[100002];
        arr[n] = 0;
        arr[100001] = Integer.MAX_VALUE - 1000;

        int cnt = 1;
        for (int i = n - 1; i >= 0 ; i--){
            arr[i] = cnt++;
        }
        cnt = 1;
        for (int i = n + 1; i <= 100000; i++) {
            arr[i] = cnt++;
        }

        for (int i = 1; i <= 100000; i++) {
            int min = Math.min(arr[i - 1], arr[i + 1]);
            if (i % 2 ==0){
                arr[i] = Math.min(arr[i], Math.min(arr[i / 2],min + 1));
            }
            else {
                arr[i] = Math.min(arr[i], min + 1);
            }
            int cur = i;
            boolean flag = true;
            while (cur > 0 && flag){
                if (arr[cur] + 1 < arr[cur - 1]){
                    arr[cur-1] = arr[cur] + 1;
                }
                else flag = false;
            }
        }

        bw.write(String.valueOf(arr[k]));
        bw.flush();
    }
}