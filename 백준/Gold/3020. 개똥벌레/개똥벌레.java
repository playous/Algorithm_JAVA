import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        // 석순
        int[] s = new int[h+2];

        // 종유석
        int[] j = new int[h+2];

        for (int i = 0; i < n; i++) {
            // 석순
            if ((i + 1) % 2 == 1) {
                s[Integer.parseInt(br.readLine())]++;
            }
            // 종유석
            else j[Integer.parseInt(br.readLine())]++;
        }

        int minTrap = n;
        int count = 0;
        int nextS = 0;
        int nextJ = 0;

        for (int i = 1; i <= h; i++) {
            int x = n/2 - (s[i-1] +nextS) + j[h - i + 1] + nextJ;
            nextS += s[i-1];
            nextJ += j[h - i + 1];
            if (x < minTrap) minTrap = x;
        }

        for (int i = 1; i <= h; i++) {
            int x = n/2 - (s[i-1] +nextS) + j[h - i + 1] + nextJ;
            nextS += s[i - 1];
            nextJ += j[h - i + 1];
            if (x == minTrap) count++ ;
        }
        bw.write(String.valueOf(minTrap) + " " + String.valueOf(count));
        bw.flush();
    }
}