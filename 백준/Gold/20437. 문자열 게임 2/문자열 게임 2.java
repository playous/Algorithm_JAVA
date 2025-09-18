import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());

            int min = Integer.MAX_VALUE;
            int max = -1;

            for (char ch = 'a'; ch <= 'z'; ch++) {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == ch) {
                        list.add(i);
                    }
                }

                if (list.size() < k) continue;

                for (int i = 0; i <= list.size() - k; i++) {
                    int start = list.get(i);
                    int end = list.get(i + k - 1);
                    int length = end - start + 1;

                    min = Math.min(min, length);
                    max = Math.max(max, length);
                }
            }

            if (min == Integer.MAX_VALUE) {
                bw.write("-1\n");
            } else {
                bw.write(min + " " + max + "\n");
            }

            t--;
        }

        bw.flush();
        bw.close();
    }
}