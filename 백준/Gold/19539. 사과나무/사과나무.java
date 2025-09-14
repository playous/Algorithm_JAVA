import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(st.nextToken());
            sum += k;
            list.add(k);
        }

        int cnt = 0;
        if (sum % 3 == 0) {
            for (int num : list) {
                cnt += num / 2;
            }
            if (cnt >= sum / 3) bw.write("YES");
            else bw.write("NO");
        }
        else bw.write("NO");

        bw.flush();
    }
}

