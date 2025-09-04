import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String p = br.readLine();

        int idx = 0;
        int cnt = 0;

        for (int i = 0; i < p.length(); i++) {
            if (s.indexOf(p.substring(idx, i+1)) != -1) continue;
            cnt++;
            idx = i;
        }

        bw.write(String.valueOf(cnt+1));

        bw.flush();
    }
}
