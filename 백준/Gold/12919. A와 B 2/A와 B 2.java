import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


class Main {
    static boolean flag = false;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        String t = br.readLine();

        canChange(s, t);
        bw.write(flag ? "1" : "0");
        bw.flush();
    }

    static void canChange(String s, String t) {
        if (s.equals(t)) flag = true;
        if (s.length() >= t.length()) return;

        if (t.charAt(t.length() - 1) == 'A') {
            canChange(s, t.substring(0, t.length() - 1));
        }

        if (t.charAt(0) == 'B') {
            String reversed = new StringBuilder(t.substring(1, t.length())).reverse().toString();
            canChange(s, reversed);
        }

    }
}