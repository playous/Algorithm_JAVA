import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        find(a,b,0);

        bw.write(String.valueOf(count));
        bw.flush();
    }

    static void find(long a, long b, long cur) {
        if (cur > b) {
            return;
        }
        if (cur >= a) {
            count++;
        }
        find(a, b, cur * 10 + 4);
        find(a, b, cur * 10 + 7);
    }
}