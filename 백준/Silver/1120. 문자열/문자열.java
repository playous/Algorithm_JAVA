import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String s1 = st.nextToken();
        String s2 = st.nextToken();

        int answer = 50;

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int cnt = 0;
            for (int j = i; j < s1.length() + i; j++) {
                if (s1.charAt(j - i) != s2.charAt(j)) {
                    cnt++;
                }
            }
            answer = Math.min(answer, cnt);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
