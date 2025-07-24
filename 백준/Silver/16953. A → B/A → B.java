import java.io.*;
import java.util.*;

public class Main {
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        dfs(a, b, 1);

        bw.write(String.valueOf(answer));
        bw.flush();
    }
    static void dfs(long a, long b, int count) {
        if (a > b) return;
        if (a == b) {
            if (answer == -1) {
                answer = count;
            } else if (count < answer) {
                answer = count;
            }
        }
        // 2 곱하기
        dfs(a * 2, b, count + 1);
        // 오른쪽에 1 추가하기
        dfs(a * 10 + 1, b, count + 1);
    }
}