import java.io.*;
import java.util.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int n;
    static int[] arr, operator;

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

        /*
        0 -> 덧셈
        1 -> 뺄셈
        2 -> 곱셈
        3 -> 나눗셈
         */
        operator = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        calc(0, arr[0]);

        bw.write(max + "\n" + min);
        bw.flush();

    }

    static void calc(int count, int cur){
        if (count == n -1) {
            if (cur > max) max = cur;
            if (cur < min) min = cur;
            return;
        }
        if (operator[0] > 0) {
            operator[0]--;
            calc(count+1, cur + arr[count+1]);
            operator[0]++;
        }
        if (operator[1] > 0) {
            operator[1]--;
            calc(count+1, cur - arr[count+1]);
            operator[1]++;
        }
        if (operator[2] > 0) {
            operator[2]--;
            calc(count+1, cur * arr[count+1]);
            operator[2]++;
        }
        if (operator[3] > 0) {
            operator[3]--;
            if (cur < 0 ) calc(count + 1, ((cur * -1) / arr[count + 1]) * -1) ;
            else calc(count + 1, cur / arr[count + 1]);
            operator[3]++;
        }
    }

}



