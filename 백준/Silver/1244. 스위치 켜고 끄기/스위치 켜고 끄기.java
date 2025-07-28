import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] switches = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 남학생 (배수)
            if (x == 1){
                man(switches, y);
            }
            // 여학생 (좌우 대칭)
            if (x == 2) {
                girl(switches, y);
            }
        }

        for (int i = 0; i <= n / 20; i++) {
            int s = 20 * i;
            for (int j = s + 1; j <= s + 20; j++) {
                if (j <= n) {
                    bw.write(switches[j] + " ");
                }
            }
            bw.write("\n");
        }

        bw.flush();
    }

    static void man(int[] switches, int y) {
        for (int i = y; i < switches.length; i += y) {
            switches[i] = switches[i] == 1 ? 0 : 1;
        }
    }

    static void girl(int[] switches, int y) {
        int s = y;
        int e = y;
        while(true){
            if(s < 1 || e >= switches.length){
                s += 1;
                e -= 1;
                break;
            }
            if(switches[s] == switches[e]){
                s--;
                e++;
            }
            else {
                s += 1;
                e -= 1;
                break;
            }
        }
        for (int i = s; i <= e; i++) {
            switches[i] = switches[i] == 1 ? 0 : 1;
        }
    }
}