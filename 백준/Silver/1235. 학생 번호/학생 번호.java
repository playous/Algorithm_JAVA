import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        int len = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        len = arr[0].length();

        HashSet<String> set = new HashSet<>();

        int answer = 0;
        for (int i = len - 1; i >= 0; i--) {
            set.clear();
            for (int j = 0; j < n; j++) {
                set.add(arr[j].substring(i, len));
            }
            if (set.size() == n) {
                answer = len - i;
                break;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}

