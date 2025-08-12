import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] arr = new int[b + 1];

        for (int i = 2; i <= b; i++) {
            if (check(i)) {
                for (int j = i; j <= b; j += i) {
                    int temp = j;
                    while (temp % i == 0) {
                        arr[j]++;
                        temp /= i;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = a; i <= b; i++) {
            if (check(arr[i])) {
                answer++;
            }
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
    }

    static boolean check(int num) {
        if (num < 2) return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}