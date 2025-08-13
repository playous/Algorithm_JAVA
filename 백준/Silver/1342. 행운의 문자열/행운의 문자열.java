import java.io.*;

public class Main {
    static int answer = 0;
    static int[] count = new int[26];
    static int len;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        len = input.length();

        for (char c : input.toCharArray()) {
            count[c - 'a']++;
        }

        backtrack(-1, 0);

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    static void backtrack(int lastChar, int curLen) {
        if (curLen == len) {
            answer++;
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0 && i != lastChar) {
                count[i]--;
                backtrack(i, curLen + 1);
                count[i]++;
            }
        }
    }
}