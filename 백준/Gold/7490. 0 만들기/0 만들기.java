import java.io.*;
import java.util.*;

public class Main {
    static List<String> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            answer = new ArrayList<>();
            calc(new char[n - 1], n, 0);
            Collections.sort(answer);
            for (String s : answer) {
                bw.write(s + "\n");
            }
            bw.newLine();
            t--;
        }
        bw.flush();
    }

    static void calc(char[] arr, int n, int cnt) {
        if (n - 1 == cnt) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                sb.append(i);
                if (i < n) {
                    sb.append(arr[i - 1]);
                }
            }
            long sum = calcSum(sb.toString());
            if (sum == 0){
                answer.add(sb.toString());
            }
            return;
        }
        arr[cnt] = '+';
        calc(arr, n, cnt + 1);
        arr[cnt] = '-';
        calc(arr, n, cnt + 1);
        arr[cnt] = ' ';
        calc(arr, n, cnt + 1);

    }

    static long calcSum (String expr) {
        long result = 0;
        long cur = 0;
        char op = '+';

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            if (c >= '0' && c <= '9') {
                cur = cur * 10 + (c - '0');
            }

            if (c == '+' || c == '-' || i == expr.length() - 1) {
                if (op == '+') {
                    result += cur;
                } else if (op == '-') {
                    result -= cur;
                }

                cur = 0;
                op = c;
            }
        }

        return result;
    }
}