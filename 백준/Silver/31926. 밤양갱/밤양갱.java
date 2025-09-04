import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int cnt = 1;
        int k = 1;
        while (k < n) {
            k = (int) Math.pow(2, cnt);
            cnt++;
        }

        if(n >= 3 && n != k) cnt--;
        bw.write(String.valueOf(9 + cnt));

        bw.flush();
    }
}
