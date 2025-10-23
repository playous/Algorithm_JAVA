import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String t = br.readLine();

        int len = t.length();
        int goalLen = s.length();

        for (int i = len - 1; i >= goalLen; i--) {
            StringBuilder sb = new StringBuilder(t);
            if (t.charAt(i) == 'A'){
                sb.deleteCharAt(i);
            }
            if (t.charAt(i) == 'B'){
                sb.deleteCharAt(i);
                sb.reverse();
            }
            t = String.valueOf(sb);
        }

        if (s.equals(t)) {
            bw.write("1");
        }
        else {
            bw.write("0");
        }

        bw.flush();
    }

}