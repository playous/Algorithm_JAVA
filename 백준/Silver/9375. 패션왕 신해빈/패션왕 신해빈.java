import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String,Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                map.put(b, map.getOrDefault(b, 0) + 1);
            }
            int answer = 1;
            for (int k : map.values()) {
                answer *= (k+1);
            }
            bw.write(answer - 1 + "\n");
            t--;
        }
        bw.flush();

    }

}