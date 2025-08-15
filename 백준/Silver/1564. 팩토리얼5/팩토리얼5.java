import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long answer = 1;

        for (int i = 2; i <= n; i++) {
            int num = i;
            answer %= 1000000000000L;
            answer *= num;
            int idx = 10;
            while (true) {
                if (answer % idx == 0) {
                    idx *= 10;
                }
                else break;
            }
            idx /= 10;
            answer /= idx;

        }

        char[] ch = new char[5];
        int idx = 4;
        while (idx >= 0){
            long k = answer % 10;
            ch[idx] = (char) (k + '0');
            idx--;
            answer /= 10;
        }

        System.out.println(new String(ch));
        bw.flush();
    }

}