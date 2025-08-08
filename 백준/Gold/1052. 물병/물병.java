import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (m >= n) {
            bw.write(String.valueOf("0"));
            bw.flush();
            return;
        }

        int[] arr = new int[30];

        arr[0] = n;

        for (int i = 0; i < 29; i++) {
            if(arr[i] == 0) break;
            int c = arr[i];
            arr[i+1] += c / 2;
            arr[i] = c % 2;
        }

        List<Integer> pow = new LinkedList<>();
        while(check(arr) > m){
            boolean flag = true;
            if(check(arr) == m - 1) flag = false;
            for (int i = 0; i < 29; i++) {
                if(arr[i] == 1) {
                    pow.add(i);
                    arr[i] = 2;
                    if(!flag) break;
                    for (int j = i ; j < 29 ; j++) {
                        if (arr[j] < 2) break;
                        int c = arr[j];
                        arr[j+1] += c / 2;
                        arr[j] = c % 2;
                    }
                    break;
                }
            }
        }
        int answer = 0;
        for (int i : pow) {
            answer += (int) Math.pow(2, i);
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }

    static int check(int[] arr) {
        int cnt = 0;
        for (int i : arr){
            if (i == 1) {
                cnt++;
            }
        }
        return cnt;
    }
}