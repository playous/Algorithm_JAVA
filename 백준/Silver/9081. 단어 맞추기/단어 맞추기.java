import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            char[] ch = br.readLine().toCharArray();

            int pivot = -1;
            for (int j = ch.length - 2; j >= 0; j--) {
                if (ch[j] < ch[j + 1]) {
                    pivot = j;
                    break;
                }
            }

            if (pivot != -1) {
                for (int j = ch.length - 1; j > pivot; j--) {
                    if (ch[j] > ch[pivot]) {
                        // 교환
                        char temp = ch[pivot];
                        ch[pivot] = ch[j];
                        ch[j] = temp;
                        break;
                    }
                }

                Arrays.sort(ch, pivot + 1, ch.length);
            }

            sb.append(String.valueOf(ch));
            if (i < n - 1) {
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}